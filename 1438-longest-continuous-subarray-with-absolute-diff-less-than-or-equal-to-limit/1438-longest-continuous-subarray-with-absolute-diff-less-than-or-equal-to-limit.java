class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int i = 0, j = 0;
        int ans = 0;
        
        // Max-heap and min-heap to keep track of max and min values in the current window
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        while (j < n) {
            max.add(nums[j]);
            min.add(nums[j]);
            
            // If the current window is invalid mean max-min > limit then left pointer ko increase kr denge, move the i pointer
            while (!max.isEmpty() && !min.isEmpty() && max.peek() - min.peek() > limit) {
                max.remove(nums[i]);
                min.remove(nums[i]);
                i++;
            }
            
            // Update the maximum length of the valid window
            ans = Math.max(ans, j - i + 1);
            
            // Expand the window
            j++;
        }
        
        return ans;
    }
}