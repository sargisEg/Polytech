package main.java.org.polytech.wumpus;

public class WumpusTest {

    public static void main(String[] args) {
        Board board = new Board(7);
        board.setWumpus(2, 0);
        board.setPit(0, 3);
        board.setPit(2, 5);
        board.setPit(3, 1);
        board.setPit(4, 1);
        board.setPit(4, 5);
        board.setGold(3, 5);
        board.printBoard();
        System.out.println(board.getSolution());
    }
}
