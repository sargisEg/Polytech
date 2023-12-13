public class Node implements Comparable<Node> {

    private final char character;
    private final int frequency;
    private final Node left;
    private final Node right;

    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public Node(Node left, Node right) {
        this.character = '\0';
        this.frequency = left.frequency + right.frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(frequency, other.frequency);
    }

    @Override
    public String toString() {
        return character + " - " + frequency;
    }

    public char getCharacter() {
        return character;
    }

    public int getFrequency() {
        return frequency;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
