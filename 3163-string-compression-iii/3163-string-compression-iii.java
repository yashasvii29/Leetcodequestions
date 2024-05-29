class Solution {
    public String compressedString(String word) {
        int len = word.length();
        StringBuilder res = new StringBuilder();
        
        char prev = word.charAt(0);
        int freq = 1;
        int i = 1;
        while (i < len) {
            char cur = word.charAt(i);
            if (cur == prev && freq < 9)   
                     freq++;
            else {
                res.append(freq).append(prev);
                prev = cur;
                freq = 1;
            }
            ++i;
        }
        
        res.append(freq).append(prev);
        
        return res.toString();
    }
}