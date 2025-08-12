class Solution {
    public int numberOfWays(int n, int x) {
        final int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int k = (int) Math.pow(i, x);
            for (int j = n; j >= k; j--) {
                dp[j] = (dp[j] + dp[j - k]) % MOD;
            }
        }
        return dp[n];
    }
}
