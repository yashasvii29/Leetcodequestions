class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int freq[] = new int[26];
        
        // Step 1: Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        
        // Step 2: Traverse from largest to smallest character
        for (int i = 25; i >= 0; i--) {
            while (freq[i] > 0) {
                int minFreq = Math.min(freq[i], repeatLimit); // Limit appending to repeatLimit
                freq[i] -= minFreq;
                
                // Append the current character minFreq times
                for (int k = 0; k < minFreq; k++) {
                    sb.append((char) ('a' + i));
                }

                // If still more of this character is left, find a smaller character to reset
                if (freq[i] > 0) {
                    boolean smallerCharFound = false;

                    for (int j = i - 1; j >= 0; j--) {
                        if (freq[j] > 0) {
                            sb.append((char) ('a' + j)); // Append one smaller character
                            freq[j]--; // Reduce frequency of the smaller character
                            smallerCharFound = true;
                            break; // Break after adding the smaller character
                        }
                    }

                    // If no smaller character exists, stop and return the current result
                    if (!smallerCharFound) {
                        return sb.toString();
                    }
                }
            }
        }

        return sb.toString();
    }
}
