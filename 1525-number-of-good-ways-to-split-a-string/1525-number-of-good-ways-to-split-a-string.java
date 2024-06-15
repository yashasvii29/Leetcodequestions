class Solution {
    public int numSplits(String s) {
         int n = s.length();
        if (n == 0) {
            return 0;
        }

        // Initialize arrays to store the number of distinct characters from the left and right
        int[] leftCount = new int[n];
        int[] rightCount = new int[n];

        // Sets to keep track of distinct characters
        Set<Character> leftSet = new HashSet<>();
        Set<Character> rightSet = new HashSet<>();

        // Fill leftCount with the number of distinct characters from the left
        for (int i = 0; i < n; i++) {
            leftSet.add(s.charAt(i));
            leftCount[i] = leftSet.size();
        }

        // Fill rightCount with the number of distinct characters from the right
        for (int i = n - 1; i >= 0; i--) {
            rightSet.add(s.charAt(i));
            rightCount[i] = rightSet.size();
        }

        // Count good splits
        int goodSplits = 0;
        for (int i = 0; i < n - 1; i++) {
            if (leftCount[i] == rightCount[i + 1]) {
                goodSplits += 1;
            }
        }

        return goodSplits;
    }
}