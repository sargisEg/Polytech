public class GcdLcm {
      
  public static void main(String[] args) {
    System.out.println(findGCD(60, 789));    
    System.out.println(findLCM(60, 789));
      
  }
      
  public static int findGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
      
  public static int findLCM(int a, int b) {
    int max = Math.max(a, b);    
    int min = Math.min(a, b);    
    int lcm = max;    
    while (lcm % min != 0) {
      lcm += max;
    }
    return lcm;
  }
}
