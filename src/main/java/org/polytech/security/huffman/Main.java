public class Main {

    public static void main(String[] args) {
        final HuffmanTree huffmanTree = new HuffmanTree("AAAAAABCCCCCCDDEEEEE");
        final String compressed = huffmanTree.getCompressed();
        System.out.println(huffmanTree.getCodeMap());
        System.out.println(compressed);
        System.out.println(HuffmanDecoder.decode(huffmanTree.getHeadOfTree(), compressed));
    }

}
