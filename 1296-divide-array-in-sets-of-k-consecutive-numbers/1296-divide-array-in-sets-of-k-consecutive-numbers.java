class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
       Arrays.sort(nums);
        int n = nums.length;
        if (n % k != 0) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int num : nums ){
            if (map.get(num) > 0) {
                // Try to form a group starting with num
                for (int i = 0; i < k; i++) {
                    int current = num + i;
                    if (map.getOrDefault(current, 0) == 0) {
                        return false;
                    }
                    map.put(current, map.get(current) - 1);
                }
            }
        }

        return true;
    }

}