class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        long sum = 0;
        StringBuilder sb = new StringBuilder();

        // Calculate cumulative shifts in reverse order
        for (int i = n - 1; i >= 0; i--) {
            sum += shifts[i];
            shifts[i] = (int)(sum % 26); // Reduce cumulative shifts to within 26
        }

        // Apply shifts to characters
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int newCharValue = (ch - 'a' + shifts[i]) % 26; // Shift and wrap within alphabet
            char shiftedChar = (char) ('a' + newCharValue); // Convert back to character
            sb.append(shiftedChar);
        }

        return sb.toString();
    }
}