package main.java.org.polytech.alg;

public class VigenereGeneral {

    public String encode(String rawText, String key) {
        StringBuilder encodedText = new StringBuilder();
        for (int i = 0, j = 0; i < rawText.length(); i++, j++) {
            if (j == key.length())
                j = 0;
            int charInText = rawText.charAt(i);
            int charInKey = key.charAt(j);
            char encodedChar = (char) ((charInText + charInKey) % 256);
            encodedText.append(encodedChar);
        }

        return encodedText.toString();
    }

    public String decode(String encodedText, String key) {
        StringBuilder decodedText = new StringBuilder();
        for (int i = 0, j = 0; i < encodedText.length(); i++, j++) {
            if (j == key.length())
                j = 0;
            int charInText = encodedText.charAt(i);
            int charInKey = key.charAt(j);
            char encryptedChar = (char) ((charInText - charInKey + 256) % 256);
            decodedText.append(encryptedChar);
        }

        return decodedText.toString();
    }

    public static void main(String[] args) {
        VigenereGeneral vigenere = new VigenereGeneral();
        String encode = vigenere.encode("attacka26^% &*_tdawn", "(lemon123)(");
        System.out.println(encode);
        System.out.println(vigenere.decode(encode   , "(lemon123)("));
    }
}
