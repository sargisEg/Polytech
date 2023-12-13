import java.util.*;

public class HuffmanTree {

    private final Node headOfTree;
    private final Map<Character, String> codeMap;
    private final String word;
    private final String compressed;

    public HuffmanTree(String word) {
        this.codeMap = new HashMap<>();
        this.word = word;
        this.headOfTree = buildTree(word);
        this.compressed = getCompressedWordFromTree();
    }

    public Node getHeadOfTree() {
        return headOfTree;
    }

    public Map<Character, String> getCodeMap() {
        return codeMap;
    }

    public String getCompressed() {
        return compressed;
    }

    private Node buildTree(String word) {
        final Map<Character, Integer> frequencyMap = getFrequency(word);

        Queue<Node> queueOfNodes = new PriorityQueue<>();
        frequencyMap.forEach((character, frequency) -> {
            final Node node = new Node(character, frequency);
            queueOfNodes.add(node);
        });

        while (queueOfNodes.size() > 1) {
            Node left = queueOfNodes.poll();
            Node right = queueOfNodes.poll();
            Node parent = new Node(left, right);
            queueOfNodes.add(parent);
        }

        final Node headOfTree = queueOfNodes.poll();
        assignCodes(headOfTree, "", codeMap);
        return headOfTree;
    }

    private Map<Character, Integer> getFrequency(String word) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    private void assignCodes(Node node, String code, Map<Character, String> codeMap) {
        if (node.getCharacter() != '\0') {
            codeMap.put(node.getCharacter(), code);
        } else {
            assignCodes(node.getLeft(), code + "0", codeMap);
            assignCodes(node.getRight(), code + "1", codeMap);
        }
    }

    private String getCompressedWordFromTree() {
        final StringBuilder compressedString = new StringBuilder();
        for (char c : word.toCharArray()) {
            compressedString.append(codeMap.get(c));
        }

        return compressedString.toString();
    }
}
