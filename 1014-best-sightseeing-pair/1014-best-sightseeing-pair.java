class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max=Integer.MIN_VALUE;
        int maxI = values[0]; // Initial max of values[i] + i
        
        for (int j = 1; j < values.length; j++) {
            // Calculate the score for the pair (i, j)
            max = Math.max(max, maxI + values[j] - j);
            // Update maxI for the next iteration
            // har j ke liye maxI find krenge
            // j =2 ke liye previous index means index 1 tak maxI find krenge
            maxI = Math.max(maxI, values[j] + j);
        }
        return max;
    }
}