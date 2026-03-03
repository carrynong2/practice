package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    static void main() {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int MAJORITY_COUNT = nums.length / 2;
        for (Map.Entry<Integer, Integer> map : countMap.entrySet()) {
           if (map.getValue() > MAJORITY_COUNT) {
               return map.getKey();
           }
        }
        return 0;
    }
}
