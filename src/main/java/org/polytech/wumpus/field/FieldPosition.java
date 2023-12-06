package main.java.org.polytech.wumpus.field;

public enum FieldPosition {
    CORNER(2),
    EDGE(3),
    MIDDLE(4);

    private final int nextFieldsCount;

    public int getNextFieldsCount() {
        return nextFieldsCount;
    }

    FieldPosition(int nextFieldsCount) {
        this.nextFieldsCount = nextFieldsCount;
    }
}
