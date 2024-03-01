class Solution {
    public boolean canPartition(int[] nums) {
        // Calculate the total sum of the array elements
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }

        // If the total sum is odd, it cannot be partitioned into equal subsets
        if (sum % 2 == 1)
            return false;
        else {
            // Calculate the target sum for each subset
            int k = sum / 2;
            // Create a memoization table
            int dp[][] = new int[nums.length][k + 1];
            for (int a[] : dp)
                Arrays.fill(a, -1);
            // Call the helper function to check if a valid subset exists
            return subsetSumUtil(nums.length - 1, k, nums, dp);
        }
    }
    
     // Helper function to check if there exists a subset with a given sum
     public  static boolean subsetSumUtil(int ind, int target, int arr[], int[][] dp) {
        // If the target sum is 0, we have found a valid subset
        if (target == 0)
            return true;

        // If we have processed all elements in the array
        if (ind == 0)
            return arr[0] == target;

        // If this subproblem has already been solved, return the result
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        // Try not taking the current element into the subset
        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        // Try taking the current element into the subset if it doesn't exceed the target
        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);

        // Memoize the result and return true if either choice results in a valid subset
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

}