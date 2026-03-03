package leetcode.easy;

import java.util.*;

public class IntersectionTwoArrayTwo {
    static void main() {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] result = intersection(num1, num2);
        System.out.println(Arrays.toString(result));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                resultList.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
