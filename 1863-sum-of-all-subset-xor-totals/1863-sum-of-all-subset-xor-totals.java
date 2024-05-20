class Solution {
    public int subsetXORSum(int[] nums) {
            return subsetXORSumHelper(nums, 0, 0);
    }

    private int subsetXORSumHelper(int[] nums, int i, int currentXOR) {
        if (i == nums.length) {
            return currentXOR;
        }
        // Include nums[i] in the subset means pick krenge
        int withElement = subsetXORSumHelper(nums, i + 1, currentXOR ^ nums[i]);
        // Exclude nums[i] from the subset means pick nhi krenge
        int withoutElement = subsetXORSumHelper(nums, i + 1, currentXOR);
        // Sum the XOR totals
        return withElement + withoutElement;
    }
}