import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long ans = 0;
        HashSet<Integer> set = new HashSet<>();
        
        int j = 0;
        
        for (int i = 0; i < nums.length; i++) {
            while (set.contains(nums[i])) {
                // Shrink the window from the j until we remove the duplicate
                set.remove(nums[j]);
                sum -= nums[j];
                j++;
            }
            
            set.add(nums[i]);
            sum += nums[i];
            
            // If the window is of size k, check for max sum and then shrink the window
            if (i - j + 1 == k) {
                ans = Math.max(ans, sum);
                set.remove(nums[j]);
                sum -= nums[j];
                j++;
            }
        }
        
        return ans;
    }
}
