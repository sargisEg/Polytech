package main.java.org.polytech.wumpus;

public class WumpusTest {

    public static void main(String[] args) {
        System.out.println("""
                [   ] - Empty field
                [( )] - Pit (Փոս)
                [~ ~] - Breeze (Քամի)
                [< >] - Wumpus (Գագո)
                [! !] - Stench (Հոտ)
                [$ $] - Gold (Ոսկի)
                
                """);
        Board board = new Board(7);
        board.setWumpus(2, 0);
        board.setPit(0, 3);
        board.setPit(2, 5);
        board.setPit(3, 1);
        board.setPit(4, 1);
        board.setPit(4, 5);
        board.setGold(6, 6);
        board.printBoard();
        System.out.println("\n" + board.getSolution());
    }
}
