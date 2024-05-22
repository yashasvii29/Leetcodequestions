class Solution {
    public int longestSubstring(String s, int k) {
        return longestSub(s, k, 0, s.length());
    }
    
    private int longestSub(String s, int k, int start, int end) {
        if (end - start < k) {
            return 0;  // If the substring is shorter than k, it can't have k repeating characters
        }
        
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        for (int i = start; i < end; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                int j = i + 1;
                while (j < end && count[s.charAt(j) - 'a'] < k) {
                    j++;
                }
                return Math.max(longestSub(s, k, start, i), longestSub(s, k, j, end));
            }
        }
        
        return end - start;  // All characters in this substring have at least k frequency
    }
}
