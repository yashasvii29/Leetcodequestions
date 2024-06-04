class Solution {
    public int longestPalindrome(String s) {
        // those characters jinki freq even h wo starting m add last m aayenge
        // then jiski odd hai wo mid m in a string

        HashMap<Character,Integer> map=new HashMap<>();
        int c=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        } 
        boolean flag=false;
        for(int val:map.values()){
            if(val%2==0){
                c+=val;
            }
            else{
                 // If frequency is odd, add the largest even part
                    c+=val-1;
                     // Note that we found at least one odd frequency
                    flag=true;
                }
            
        }
         // If there's any character with an odd frequency, we can place one odd character in the center
        if(flag){
            c+=1;
        }
        return c;
    }
}