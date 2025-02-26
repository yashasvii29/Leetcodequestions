class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int prefixSum = 0, maxSum = 0, minSum = 0;

        for (int num : nums) {
            prefixSum += num;
            maxSum = Math.max(maxSum, prefixSum);  // Track max prefix sum
            minSum = Math.min(minSum, prefixSum);  // Track min prefix sum
        }

        return maxSum - minSum;  // Maximum absolute sum
    
    }
}