// /this is a brute force approach

// class Solution {
//     public boolean canPartition(int[] arr) {

//         // this que is same as split array
//         return Printsubset1(arr,0,0,0);
//     }
//     public static boolean Printsubset1(int arr[], int i,int sum1,int sum2){
        
     
//         if (i == arr.length) {
//             return sum1 == sum2;
//         }

//         // Option 1: Add arr[i] to subset2
//         boolean without = Printsubset1(arr, i + 1, sum1, sum2 + arr[i]);

//         // Option 2: Add arr[i] to subset1
//         boolean with = Printsubset1(arr, i + 1, sum1 + arr[i], sum2);

//         return with || without;
//     }
// }


// optimize code

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
