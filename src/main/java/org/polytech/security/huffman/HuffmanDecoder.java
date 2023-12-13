public class HuffmanDecoder {

    public static String decode(Node treeHead, String compressed) {

        final StringBuilder expanded = new StringBuilder();

        Node node = treeHead;
        for (char code : compressed.toCharArray()) {
            if (code == '0') {
                node = node.getLeft();
            } else if (code == '1') {
                node = node.getRight();
            }
            if (node.getCharacter() != '\0') {
                expanded.append(node.getCharacter());
                node = treeHead;
            }
        }

        return expanded.toString();
    }
}
