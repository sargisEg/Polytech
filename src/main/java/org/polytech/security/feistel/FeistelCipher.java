import java.util.Arrays;

public class FeistelCipher {

    public static void main(String[] args) {

        
        final byte[] key = "asdasd".getBytes();
        final FeistelCipher feistelCipher = new FeistelCipher(key, 16);
        final String test = feistelCipher.encrypt("test test2 test3");
        System.out.println(test);
        final String decrypt = feistelCipher.decrypt(test);
        System.out.println(decrypt);
    }

    private final byte[] key;
    private final int rounds;

    public FeistelCipher(byte[] key, int rounds) {
        this.key = key;
        this.rounds = rounds;
    }

    public String encrypt(String plainText) {
        final byte[] byteArray = plainText.getBytes();
        byte[] cipherText = new byte[byteArray.length];

        encryptBlock(byteArray, cipherText);

        return new String(cipherText);
    }

    public String decrypt(String cipherText) {
        final byte[] byteArray = cipherText.getBytes();
        byte[] plainText = new byte[byteArray.length];

        decryptBlock(byteArray, plainText);

        return new String(plainText);
    }

    private void encryptBlock(byte[] block, byte[] cipherText) {
        byte[] left = Arrays.copyOfRange(block, 0, block.length / 2);
        byte[] right = Arrays.copyOfRange(block, block.length / 2, block.length);

        for (int round = 0; round < rounds; round++) {
            byte[] temporary = right;
            right = xor(left, function(right, roundKey(round)));
            left = temporary;
        }

        System.arraycopy(left, 0, cipherText, 0, left.length);
        System.arraycopy(right, 0, cipherText, left.length, right.length);
    }

    private void decryptBlock(byte[] block, byte[] plainText) {
        byte[] left = Arrays.copyOfRange(block, 0, block.length / 2);
        byte[] right = Arrays.copyOfRange(block, block.length / 2, block.length);

        for (int round = rounds - 1; round >= 0; round--) {
            byte[] temporary = right;
            right = left;
            left = xor(temporary, function(right, roundKey(round)));
        }

        System.arraycopy(left, 0, plainText, 0, left.length);
        System.arraycopy(right, 0, plainText, left.length, right.length);
    }

    private byte[] function(byte[] bytes, byte[] roundKey) {
        byte[] result = new byte[bytes.length];

        for (int i = 0, j = 0; i < bytes.length; i++, j++) {
            result[i] = (byte) (bytes[i] ^ roundKey[j]);
            if (j == roundKey.length - 1)
                j = 0;
        }

        return result;
    }

    private byte[] roundKey(int round) {
        return key;
    }

    private byte[] xor(byte[] a, byte[] b) {
        byte[] result = new byte[a.length];

        for (int i = 0; i < a.length; i++) {
            result[i] = (byte) (a[i] ^ b[i]);
        }

        return result;
    }
}
