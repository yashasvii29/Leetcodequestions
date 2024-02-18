class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int[][] dp1 = new int[n][n];
        int[][] dp2 = new int[n][n];
        int[][] dp3 = new int[n][n];
        
        int c1 = helper(nums, 0, n-1, nums[0]+nums[1], dp1);
        int c2 = helper(nums, 0, n-1, nums[0]+nums[n-1], dp2);
        int c3 = helper(nums, 0, n-1, nums[n-1]+nums[n-2], dp3);
        return Math.max(c1, Math.max(c2, c3));
    }
    
    public int helper(int[] nums, int i, int j, int val, int[][] dp) {
        if(i >= j) return 0;
        
        if(dp[i][j] != 0) return dp[i][j];
        
        int p1 = 0, p2 = 0, p3 = 0;
        if(i+1 <= j && nums[i]+nums[i+1] == val)
            p1 = 1 + helper(nums, i+2, j, val, dp);
        
        if(nums[i]+nums[j] == val) 
            p2 = 1 + helper(nums, i+1, j-1, val, dp);
        
        if(j-1 >= i && nums[j-1]+nums[j] == val) 
            p3 = 1 + helper(nums, i, j-2, val, dp);
        
        dp[i][j] = Math.max(p1, Math.max(p2, p3));
        return dp[i][j];
    }
}