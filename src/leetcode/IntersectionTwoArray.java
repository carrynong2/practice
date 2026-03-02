package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionTwoArray {
    static void main() {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] result = intersection(num1, num2);
        System.out.println(Arrays.toString(result));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }
        return result;
    }
}
