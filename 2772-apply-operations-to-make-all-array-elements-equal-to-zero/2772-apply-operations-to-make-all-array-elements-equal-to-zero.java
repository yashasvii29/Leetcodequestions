class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int curr = 0;

        for (int i = 0; i < n; i++) {
            curr += diff[i]; // apply pending operations up to index i
            nums[i] -= curr;

            if (nums[i] < 0) return false;

            if (nums[i] > 0) {
                if (i + k > n) return false; // cannot apply operation beyond array bounds

                curr += nums[i]; // apply nums[i] operations starting at i
                diff[i + k] -= nums[i]; // end the effect at i + k
            }
        }

        return true;
    }
}
