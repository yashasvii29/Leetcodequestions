class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0, oddCount = 0;
        int[] prefixSums = new int[nums.length + 1];
        prefixSums[0] = 1;  // Initialize with 1 to handle cases where a subarray starts at index 0
        
        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
            if (oddCount >= k) {
                count += prefixSums[oddCount - k];
            }
            prefixSums[oddCount]++;
        }
        
        return count;
    }
}
