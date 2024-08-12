import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array first
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];  // Initialize the closest sum with the first three elements

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                // If the sum is exactly equal to the target, return it immediately
                if (sum == target) {
                    return sum;
                }

                // Update the closest sum if this one is closer to the target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // Move the pointers based on the sum
                if (sum < target) {
                    j++;  // Move the left pointer to the right to increase the sum
                } else {
                    k--;  // Move the right pointer to the left to decrease the sum
                }
            }
        }

        return closestSum;
    }
}
