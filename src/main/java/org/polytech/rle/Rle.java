public class Rle {
    public static void main(String[] args) {
        byte[] a = rleEncode("AAAjbasjdbabsdjjajjjaassbbbdjkkkkkkjkalsnddddd");
        System.out.println(rleDecode(a));
    }

    public static byte[] rleEncode(String rawText) {
        StringBuilder encoded = new StringBuilder();
        char pivot = rawText.charAt(0);
        int count = 1;
        for (int i = 1; i < rawText.length(); i++) {
            if (pivot == rawText.charAt(i)) {
                count++;
                continue;
            }
            encoded.append(count).append(pivot);
            pivot = rawText.charAt(i);
            count = 1;
        }
        encoded.append(count).append(pivot);
        System.out.println(encoded);
        return encoded.toString().getBytes();
    }

    public static String rleDecode(byte[] encoded) {
        String encodedString = new String(encoded);
        StringBuilder decodedString = new StringBuilder();
        for (int i = 0; i < encodedString.length(); i += 2) {
            int count = Integer.parseInt(String.valueOf(encodedString.charAt(i)));
            char character = encodedString.charAt(i + 1);
            for (int j = 0; j < count; j++) {
                decodedString.append(character);
            }
        }

        return decodedString.toString();
    }
}
