package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    static void main() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] res = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int num = stack.pop();
                for (int j = 0; j < nums1.length; j++) {
                    if (nums1[j] == num) {
                        res[j] = nums2[i];
                    }
                }
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            int num = stack.pop();
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] == num) {
                    res[j] = -1;
                }
            }
        }
        return res;
    }
}
