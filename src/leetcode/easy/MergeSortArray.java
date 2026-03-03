package leetcode.easy;

import java.util.PriorityQueue;

public class MergeSortArray {
    static void main() {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            minHeap.offer(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            minHeap.offer(nums2[i]);
        }
        for (int i = 0; i < m + n; i++) {
            if (minHeap.isEmpty()) {
                break;
            }
            nums1[i] = minHeap.poll();
        }
        System.out.println("nums1 = " + java.util.Arrays.toString(nums1));
    }
}
