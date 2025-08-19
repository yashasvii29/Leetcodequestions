class Solution {
    public int longestContinuousSubstring(String s) {
         int maxLen = 1; // at least one character
        int currLen = 1;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) - s.charAt(i-1) == 1) {
				currLen ++;
				maxLen = Math.max(maxLen,currLen );
			}
			else {
				currLen  = 1;
			}
		}
		
		return maxLen;
    }
}