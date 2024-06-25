class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flipCount = 0;   // This will count the number of flips
        int result = 0;
        int[] isFlipped = new int[n];  // This array will help us track flips

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipCount ^= isFlipped[i - k];
            }
            if ((nums[i] ^ flipCount) == 0) {
                if (i + k > n) {
                    return -1;  // If there aren't enough bits left to flip, return -1
                }
                result++;
                flipCount ^= 1;  // Flip the current bit
                if (i < n) {
                    isFlipped[i] = 1;  // Mark the flip
                }
            }
        }
        return result;
    }
}
