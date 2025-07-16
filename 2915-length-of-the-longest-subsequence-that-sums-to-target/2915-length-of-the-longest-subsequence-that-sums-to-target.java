class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        // same as coin change
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (dp[i - num] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - num] + 1);
                }
            }
        }

        return dp[target];
    }
}
