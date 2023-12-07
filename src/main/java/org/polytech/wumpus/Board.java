package main.java.org.polytech.wumpus;

import main.java.org.polytech.wumpus.field.Field;
import main.java.org.polytech.wumpus.field.FieldPosition;
import main.java.org.polytech.wumpus.field.FieldStatus;
import main.java.org.polytech.wumpus.field.FieldType;

import java.util.LinkedList;
import java.util.List;

public class Board {

    private boolean isSolved = false;
    private final int boardSize;
    private final Field[][] board;

    public Board(int size) {
        this.boardSize = size;
        board = new Field[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    if (i == j || i + j == size - 1) {
                        board[i][j] = new Field(FieldPosition.CORNER, (i*size + j + 1));
                    } else {
                        board[i][j] = new Field(FieldPosition.EDGE, (i*size + j + 1));
                    }
                } else {
                    board[i][j] = new Field(FieldPosition.MIDDLE, (i*size + j + 1));
                }
            }
        }

        //Only this method is written by chatGPT :)
        setNeighbors();

    }

    private void setNeighbors() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Field currentField = board[i][j];

                // Connect to the right neighbor (if it exists)
                if (j < boardSize - 1) {
                    currentField.setNextField(board[i][j + 1]);
                }

                // Connect to the bottom neighbor (if it exists)
                if (i < boardSize - 1) {
                    currentField.setNextField(board[i + 1][j]);
                }

                // Connect to the left neighbor (if it exists)
                if (j > 0) {
                    currentField.setNextField(board[i][j - 1]);
                }

                // Connect to the top neighbor (if it exists)
                if (i > 0) {
                    currentField.setNextField(board[i - 1][j]);
                }
            }
        }
    }

    public void setWumpus(int i, int j) {
        board[i][j].setType(FieldType.WUMPUS);
    }

    public void setPit(int i, int j) {
        board[i][j].setType(FieldType.PIT);
    }

    public void setGold(int i, int j) {
        board[i][j].setType(FieldType.GOLD);
    }

    public void printBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.printf("%4s",board[i][j]);
            }
            System.out.println();
        }
    }

    public List<Integer> getSolution() {
        LinkedList<Integer> solutionPath = new LinkedList<>();
        Field startField = board[0][0];
        startField.setStatus(FieldStatus.SAFE);
        checkNeighborFields(startField, solutionPath);

        return solutionPath;
    }

    private void checkNeighborFields(Field field, LinkedList<Integer> path) {
        field.setChecked(true);
        //If board not solved yet add current field number to the path
        if (!isSolved)
            path.addLast(field.getNumber());
        else
            return;

        //If current field contains gold mark board as solved
        if (isFieldGold(field)) {
            isSolved = true;
            return;
        }

        //Find type of the current field
        checkFieldForDefault(field);
        checkFieldForBreeze(field);
        checkFieldForStench(field);
        checkFieldForStenchBreeze(field);

        //If board not solved yet check neighbors of current field
        if (!isSolved) {
            field.getNextFields().forEach(neighbor -> {
                if (!neighbor.isChecked() && neighbor.getStatus() == FieldStatus.SAFE) {
                    checkNeighborFields(neighbor, path);
                }
            });
        }

        //If after neighbors checking board still not solved remove current field number from path
        if (!isSolved)
            path.removeLast();
    }

    private boolean isFieldGold(Field field) {
        return field.getType() == FieldType.GOLD ||
                field.getType() == FieldType.BREEZE_GOLD ||
                field.getType() == FieldType.STENCH_GOLD ||
                field.getType() == FieldType.STENCH_BREEZE_GOLD;
    }

    private void checkFieldForStenchBreeze(Field field) {
        if (field.getType() == FieldType.STENCH_BREEZE) {
            field.getNextFields().forEach(neighbor -> {
                if (neighbor.getStatus() == null) {
                    neighbor.setStatus(FieldStatus.DANGER);
                }
            });
        }
    }

    private void checkFieldForStench(Field field) {
        if (field.getType() == FieldType.STENCH) {
            field.getNextFields().forEach(neighbor -> {
                if (neighbor.getStatus() == FieldStatus.DANGER_PIT) {
                    neighbor.setStatus(FieldStatus.SAFE);
                } else if (neighbor.getStatus() == null) {
                    neighbor.setStatus(FieldStatus.DANGER_WUMPUS);
                }
            });
        }
    }

    private void checkFieldForBreeze(Field field) {
        if (field.getType() == FieldType.BREEZE) {
            field.getNextFields().forEach(neighbor -> {
                if (neighbor.getStatus() == FieldStatus.DANGER_WUMPUS) {
                    neighbor.setStatus(FieldStatus.SAFE);
                } else if (neighbor.getStatus() == null) {
                    neighbor.setStatus(FieldStatus.DANGER_PIT);
                }
            });
        }
    }

    private void checkFieldForDefault(Field field) {
        if (field.getType() == FieldType.DEFAULT) {
            field.getNextFields().forEach(neighbor -> neighbor.setStatus(FieldStatus.SAFE));
        }
    }
}
