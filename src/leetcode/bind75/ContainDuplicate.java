package leetcode.bind75;

import java.util.HashMap;
import java.util.Map;

public class ContainDuplicate {
    static void main() {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 1);
            }
        }
        return false;
    }
}
