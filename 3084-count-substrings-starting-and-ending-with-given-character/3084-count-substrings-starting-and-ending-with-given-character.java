class Solution {
    public long countSubstrings(String s, char c) {

           long ans = 0,cnt=0;
        long n = s.length();
        for(int i=0;i<n;i++){
          if(s.charAt(i)==c){
            cnt++;
            ans+=cnt;
          } 
                 
        }
        return ans;
    }
}








    //     // brute force which gives tle
    //    long ans = 0;
    //     long n = s.length();
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             String ch = s.substring(i,j+1);
    //             if(ch.charAt(0)==c && ch.charAt(ch.length()-1)==c){
    //                 ans++;
    //             }
    //         }
    //     }
    //     return ans;
        
        
        
        
        
        
