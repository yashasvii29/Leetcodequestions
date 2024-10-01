class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
       // Create a list to store ans
        List<List<Integer>> ans = new ArrayList<>();
        
        // Traverse the 2D list and collect elements in diagonal fashion
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                // i + j gives the diagonal index
                if (ans.size() <= i + j) {
                    ans.add(new ArrayList<>()); // Add a new diagonal if needed
                }
                ans.get(i + j).add(nums.get(i).get(j)); // Add element to the correct diagonal
                sum++; // Track total number of elements
            }
        }

        // Create result array
        int[] result = new int[sum];
        int index = 0;

        // Add elements from ans to result array
        for (int d = 0; d < ans.size(); d++) {
            // Reverse elements for each diagonal to follow top-to-bottom order
            Collections.reverse(ans.get(d));
            for (int val : ans.get(d)) {
                result[index++] = val;
            }
        }

        return result;
    }
}