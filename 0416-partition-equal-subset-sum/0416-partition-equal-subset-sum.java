import java.util.Arrays;

class Solution {

    public static boolean partion(int n,
                                  int[] nums,
                                  int[][] dp,
                                  int target) {

        // We successfully made the target
        if (target == 0) {
            return true;
        }

        // No elements left
        if (n < 0) {
            return false;
        }

        // Already calculated
        if (dp[n][target] != -1) {
            return dp[n][target] == 1;
        }

        // DON'T TAKE
        boolean dontake = partion(
            n - 1,
            nums,
            dp,
            target
        );

        // TAKE
        boolean take = false;

        if (nums[n] <= target) {

            take = partion(
                n - 1,
                nums,
                dp,
                target - nums[n]
            );
        }

        // Either take OR don't take
        boolean result = take || dontake;

        // Store result
        dp[n][target] = result ? 1 : 0;

        return result;
    }

    public boolean canPartition(int[] nums) {

        int n = nums.length;

        int total = 0;

        // Calculate total sum
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }

        // Odd sum cannot be divided equally
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return partion(n - 1, nums, dp, target);
    }
}