class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
           HashMap<Integer, Integer> map = new HashMap<>();
        
        // Calculate all possible sums of pairs from nums1 and nums2 and store in the map
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        int count = 0;

          // For each possible sum of pairs from nums3 and nums4,
        // check if the negated sum exists in the map
        for (int k : nums3) {
            for (int l : nums4) {
                int target = -(k + l);
                if (map.containsKey(target)) {
                    count += map.get(target);
                }
            }
        }
        
        return count;
    }
}