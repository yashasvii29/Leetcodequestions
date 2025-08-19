class Solution {
    public int maxVowels(String s, int k) {
          int n = s.length();
        int c = 0;
      

        // count vowels in the first window

        for (int i = 0; i < k; i++) {

            if (isVowel(s.charAt(i))){
                c++;
            } 
            
        }
       int max = c;

        // Slide the window
        for (int i = k; i < n; i++) {
            if (isVowel(s.charAt(i))){
                 // add new char
                c++; //window grow kr rhe h
            }        
            if (isVowel(s.charAt(i - k))) {
                c--;   // window shrink kr rhe h
                 // remove old char
            
             }
            max = Math.max(max, c);       // update max
        }

        return max;
    }

    private boolean isVowel(char c) {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}