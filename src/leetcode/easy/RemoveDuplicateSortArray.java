package leetcode.easy;

public class RemoveDuplicateSortArray {
    static void main() {
        int[] nums = {1, 1, 2};
        int res = new RemoveDuplicateSortArray().removeDuplicates(nums);
        System.out.println(res);
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }
}
