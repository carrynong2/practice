package leetcode;

public class PowerOfFour {
    static void main() {
        int n = 16;
        System.out.println(isPowerOfFour(n));
    }
    public static boolean isPowerOfFour(int n) {
        int four = 4;
        if (n <= 0) {
            return false;
        }
        while (n % four == 0) {
            n /= four;
        }
        return n == 1;
    }
}
