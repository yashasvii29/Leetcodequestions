class Solution {
    public boolean canPartition(int[] nums) {
           int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If total sum is odd, we can't partition it into two equal subsets
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        int n = nums.length;

        // dp[i] = true if a subset with sum i is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // sum 0 is always possible (empty subset)

        for (int num : nums) {
            // Traverse backwards to avoid overwriting results
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}