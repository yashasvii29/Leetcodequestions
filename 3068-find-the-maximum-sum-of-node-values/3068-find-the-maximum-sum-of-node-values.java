class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
         long ans = 0, total_diff = 0, positive_count = 0, min_abs_diff = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            ans += nums[i];
            int xor = nums[i] ^ k;
            int diff = xor - nums[i];

            if(diff > 0) {
                total_diff += diff;
                positive_count++;
            }

            min_abs_diff = Math.min(min_abs_diff, Math.abs(diff));
        }

        if(positive_count % 2 == 1) {
            total_diff -= min_abs_diff;
        }

        return ans + total_diff;
    }
}