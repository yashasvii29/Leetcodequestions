class Solution {
    public String longestPrefix(String s) {
        // using kmp algorithm
      return   Happy_Prefix(s);
       
        // longest prefix find krna hai  which is also suffix 
        // string m se aisi substring find krni which is prefix and suffix as well
        
    }

     public static String Happy_Prefix(String s){
        int dp[] = new int[s.length()];
        int len =0;
        for(int i=1;i<dp.length;){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                dp[i]=len;
                i++;
            }
            else{
                if(len>0){
                    len = dp[len-1];
                }
                else{
                    i++;
                }
                
            }
        }
        return s.substring(0,dp[s.length()-1]);
        // return str;
    }
}