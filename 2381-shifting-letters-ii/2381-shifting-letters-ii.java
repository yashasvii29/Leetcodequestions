class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
             int n = s.length();
        int[] shiftArray = new int[n + 1]; // Difference array to calculate cumulative shifts

        // Process each shift operation using the difference array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            int shiftValue = (direction == 1) ? 1 : -1;

            shiftArray[start] += shiftValue;
            if (end + 1 < n) {
                shiftArray[end + 1] -= shiftValue;
            }
        }

        // Calculate the net shifts for each character
        int runningShift = 0;
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            runningShift += shiftArray[i];
            int shiftValue = (runningShift % 26 + 26) % 26; // Ensure positive shift within range
            result[i] = (char) ('a' + (result[i] - 'a' + shiftValue) % 26);
        }

        return new String(result);
    
    }
}