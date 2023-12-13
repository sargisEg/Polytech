public class SimpleSubstitution {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        final String encoded = encode("keywordmypproa", "Hi how are you");
        System.out.println(encoded);
        System.out.println(decode("keywordmypproa", encoded));
    }

    public static String encode(String keyword, String rawText) {

        final String key = getKey(keyword);

        final StringBuilder encodedText = new StringBuilder();

        for (char c : rawText.toLowerCase().toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                continue;
            }
            encodedText.append(key.charAt(alphabet.indexOf(c)));
        }

        return encodedText.toString();
    }

    public static String decode(String keyword, String encodedText) {

        final String key = getKey(keyword);

        final StringBuilder decodedText = new StringBuilder();

        for (char c : encodedText.toLowerCase().toCharArray()) {
            decodedText.append(alphabet.charAt(key.indexOf(c)));
        }

        return decodedText.toString();
    }

    private static String getKey(String keyword) {
        StringBuilder key = new StringBuilder();
        for (char c : keyword.toLowerCase().toCharArray()) {
            if (key.toString().indexOf(c) == -1) {
                key.append(c);
            }
        }

        if (key.length() != 26) {
            for (char c : alphabet.toCharArray()) {
                if (key.toString().indexOf(c) == -1) {
                    key.append(c);
                }
            }
        }
        return key.toString();
    }
}
