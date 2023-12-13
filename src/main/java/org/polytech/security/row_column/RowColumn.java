public class RowColumn {
  
    public static void main(String[] args) {
        String encoded = rowColumnEncode("asdjbasdkandjasd", 3);
        rowColumnDecode(encoded, 3);
    }
  
    public static String rowColumnEncode(String rawText, int n) {
        System.out.println(rawText);
        int rowLength = n;
        int columnLength = rawText.length() / n + 1;
        char[][] firstMatrix = new char[columnLength][rowLength];
        for (int i = 0; i < rawText.length(); i++) {
            firstMatrix[i / rowLength][i % rowLength] = rawText.charAt(i);
        }

//        print(firstMatrix);
        char[][] secondMatrix = switchMatrix(firstMatrix);
//        print(secondMatrix);

        StringBuilder encodedText = new StringBuilder();
        for (char[] row : secondMatrix) {
            for (char i : row) {
                encodedText.append(i);
            }
        }
        System.out.println(encodedText);
        return encodedText.toString();
    }

    public static String rowColumnDecode(String encodedText, int n) {
        System.out.println(encodedText);
        int columnLength = n;
        int rowLength = encodedText.length() / n;
        char[][] firstMatrix = new char[columnLength][rowLength];
        for (int i = 0; i < encodedText.length(); i++) {
            firstMatrix[i / rowLength][i % rowLength] = encodedText.charAt(i);
        }

//        print(firstMatrix);
        char[][] secondMatrix = switchMatrix(firstMatrix);
//        print(secondMatrix);

        StringBuilder decodedText = new StringBuilder();
        for (char[] row : secondMatrix) {
            for (char i : row) {
                decodedText.append(i);
            }
        }
        System.out.println(decodedText);
        return decodedText.toString();
    }

    private static char[][] switchMatrix(char[][] firstMatrix) {
        char[][] newMatrix = new char[firstMatrix[0].length][firstMatrix.length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = firstMatrix[j][i];
            }
        }
        return newMatrix;
    }
}
