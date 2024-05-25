class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
         Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // An empty string can always be segmented.

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further if we found a valid segmentation.
                }
            }
        }
        
        return dp[n]; // The result for the full string.
    }
}