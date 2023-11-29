package main.java.org.polytech.alg;

public class Vigenere {

    /*
    ascii
    a - 97
    .
    .
    z - 122
    */
    public String encode(String rawText, String key) {
        StringBuilder encodedText = new StringBuilder();
        for (int i = 0, j = 0; i < rawText.length(); i++, j++) {
            if (j == key.length())
                j = 0;
            int charInText = rawText.charAt(i) - 97;
            int charInKey = key.charAt(j) - 97;
            char encodedChar = (char) (((charInText + charInKey) % 26) + 97);
            encodedText.append(encodedChar);
        }

        return encodedText.toString();
    }

    public String decode(String encodedText, String key) {
        StringBuilder decodedText = new StringBuilder();
        for (int i = 0, j = 0; i < encodedText.length(); i++, j++) {
            if (j == key.length())
                j = 0;
            int charInText = encodedText.charAt(i) - 97;
            int charInKey = key.charAt(j) - 97;
            char encryptedChar = (char) (((charInText - charInKey + 26) % 26) + 97);
            decodedText.append(encryptedChar);
        }

        return decodedText.toString();
    }

    public static void main(String[] args) {
        Vigenere vigenere = new Vigenere();
        String encode = vigenere.encode("attackatdawn", "lemon");
        System.out.println(encode);
        System.out.println(vigenere.decode(encode   , "lemon"));
    }
}
