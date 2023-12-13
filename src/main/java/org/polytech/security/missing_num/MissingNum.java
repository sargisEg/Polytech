public class MissingNum {
    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{3, 6, 5, 7, 4, 1, 2}));
    }

      public static int findMissingNumber(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int n = arr.length + 1;

        int sumN = n * (n + 1) / 2;

        return sumN - sum;
    }
}
