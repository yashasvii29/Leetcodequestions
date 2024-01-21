class Solution {
    public int combinationSum4(int[] candidates, int target) {
        // this question is same as coin permutation

        // top down approach 
        
         int[] dp = new int[target+1];
        
        Arrays.fill(dp,-1);
        return Combinations(candidates, target,dp);
    }
    private int Combinations(int[] candidates, int target,int[] dp){
        if(target==0){
            return 1;
        }
        if(dp[target]!=-1){
            return dp[target];
        }

        int c=0;
        for(int i=0;i<candidates.length;i++)
        
        {
            if(candidates[i]<=target)
            
            {
                c+= Combinations(candidates,target-candidates[i],dp);
            }
            
            
            }
            
            return dp[target]=c;
        }
    }
