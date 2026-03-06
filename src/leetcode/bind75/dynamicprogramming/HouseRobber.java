package leetcode.bind75.dynamicprogramming;

public class HouseRobber {
    static void main() {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dp[i] = Math.max(nums[0], nums[1]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        return dp[nums.length - 1];
    }
}
