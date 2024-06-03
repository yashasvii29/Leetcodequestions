class Solution {
    public int appendCharacters(String s, String t) {
        // int ans=0;
         int sLen = s.length();
      int tLen = t.length();
 
      
      int i = 0;
      int j = 0;
 
      while (i < sLen && j < tLen) {
 
          if (s.charAt(i) == t.charAt(j)){
             j++;
             // k wali string ko check kr rhe h
          }
          i++;
       }
 
       return t.length()-j;
    }
}