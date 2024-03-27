class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        // semi repititive means  string m koi 1 digit 2 baar aa sakti hai 
         int ans = 0;
        for(int i=0;i<s.length();i++){
            StringBuilder str = new StringBuilder();
            for(int j=i;j<s.length();j++){
                str.append(s.charAt(j));
                if(isValid(str.toString())){
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }
     public static boolean isValid(String s){
        int pair = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                pair++;
            }
        }
        return pair<=1;
    }
}