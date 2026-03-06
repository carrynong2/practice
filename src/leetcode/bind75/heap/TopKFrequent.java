package leetcode.bind75.heap;

import java.util.*;

public class TopKFrequent {
    static void main() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println(java.util.Arrays.toString(result));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) ->
                countMap.get(b).compareTo(countMap.get(a)));
        for (int n : countMap.keySet()) {
            maxHeap.offer(n);
        }
        int current = k;
        int[] result = new int[k];
        while (current-- > 0) {
            if (maxHeap.isEmpty()) {
                break;
            }
            result[k - current - 1] = maxHeap.poll();
        }
        return result;
    }
}
