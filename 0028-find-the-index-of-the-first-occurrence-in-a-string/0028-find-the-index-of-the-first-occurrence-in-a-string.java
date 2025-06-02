class Solution {
    public int strStr(String haystack, String needle) {
        int s1 = haystack.length();
        int s2=needle.length();
        // edge cases
        if(haystack.equals(needle)){
            return 0;
        }
        if(s1<s2){
            return -1;
        }
        int len=0;
          for (int i = 0; i <= s1 - s2; i++) {
            int j = 0;
            while (j < s2 && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == s2) return i;  // full match found
        }
        return -1;




        // 1 line solution using indexOf method
        // return haystack.indexOf(needle);
    }
        
}
    
        
    
 