package dsa;

import java.util.*;

public class HeapQuestionExample {
    static void main() {
        System.out.println("Top K Frequent Elements: "
                + topKFrequentElement(new int[]{1, 1, 1, 2, 2, 3}, 2));
        System.out.println("K Closest Points: "
                + kClosestPoints(List.of(List.of(3, 3), List.of(5, -1), List.of(-2, 4)), 2));
    }
    private static List<Integer> topKFrequentElement(int[] nums, int k) {
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
        List<Integer> result = new ArrayList<>();
        while (current-- > 0) {
            result.add(maxHeap.poll());
        }
        return result;
    }
    private static int euclideanDistance(List<Integer> point) {
        return point.get(0) * point.get(0) + point.get(1) * point.get(1);
    }
    private static List<List<Integer>> kClosestPoints(List<List<Integer>> points, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(euclideanDistance(a), euclideanDistance(b)));
        minHeap.addAll(points);
        List<List<Integer>> result = new ArrayList<>();
        var current = k;
        while (current-- > 0) {
            result.add(minHeap.poll());
        }
        return result;
    }
}
