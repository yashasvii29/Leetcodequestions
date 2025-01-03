class Solution {
    public int maxScore(String s) {
        int totalOnes=0;
        int maxScore=0;
        int currentZeros=0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                totalOnes++;
            }
        }

        // Traverse the string to calculate scores for splits
        // for each i we will split the string
        for (int i = 0; i < s.length() - 1; i++) { // Ensure non-empty substrings
            if (s.charAt(i) == '0') {
                currentZeros++; // Increment left zeros count
            } else {
                totalOnes--; // Decrement right ones count
            }

            // Calculate the score for the current split
            // no. of zeros in the left + no. of zeros in the right
            maxScore = Math.max(maxScore, currentZeros + totalOnes);
        }

        return maxScore;
    }
}