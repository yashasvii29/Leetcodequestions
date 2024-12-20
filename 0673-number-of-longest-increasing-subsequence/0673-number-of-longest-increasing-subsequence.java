class Solution {
    public int findNumberOfLIS(int[] nums) {
        // time complexity O(n2)
    int dp[]=new int[nums.length];
    int count[]=new int[nums.length];
    Arrays.fill(dp,1);
     Arrays.fill(count, 1);  
    for(int i=1;i<dp.length;i++){
        for(int j=0;j<i;j++){
              if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;   // Update LIS length
                        count[i] = count[j]; // Reset count to count[j]
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j]; // Add count[j] to count[i]
                    }
                }
            }
        }
    int max=Integer.MIN_VALUE;
    for(int i=0;i<dp.length;i++){
       max=Math.max(max,dp[i]);
    }
    int c=0;
    for(int i=0;i<dp.length;i++){
        if(dp[i]==max){
            c+=count[i];
        }
    }
    
    return c;  
    }
}