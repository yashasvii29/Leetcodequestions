class Solution {
    public long zeroFilledSubarray(int[] nums) {
           long ans = 0;
        long currLen = 0; // current streak of zeros

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currLen++;
                ans += currLen; // every new zero adds new subarrays
            } else {
                currLen = 0; // reset when non-zero appears
            }
        }

        return ans;
    }
}