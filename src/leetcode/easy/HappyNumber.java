package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    static void main() {
        System.out.println(isHappy(19));
    }
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
