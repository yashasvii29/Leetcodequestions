class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int max = 0;
        int cost = 0;
        int i = 0; // start
        // j means end

        for (int j = 0; j < s.length(); j++) {
            // Calculate the cost of changing s[j] to t[j]
            cost += Math.abs(s.charAt(j) - t.charAt(j));

            // If the current cost exceeds maxCost, move the i of the window
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }

            // Update the maximum length found so far
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}
