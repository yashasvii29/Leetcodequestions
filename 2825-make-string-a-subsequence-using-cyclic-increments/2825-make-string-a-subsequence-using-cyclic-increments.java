class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
          
        return can(str1 , 0 , str2 , 0);
    }
    private boolean can(String s1 , int i , String s2 , int j){
        if(j == s2.length()){
            return true;
        }
        if(i == s1.length()){
            return false;
        }
        
        if(s1.charAt(i) == s2.charAt(j)){
            boolean a = can(s1 , i+1 , s2 , j+1);
            return a;
        }
        else

            {
                boolean choose =false;
                boolean not_choose=false;
                int sp=(s1.charAt(i)+1-97)%26;
                int sd=(s2.charAt(j)-97)%26;
                if(sp==sd){
                    choose=can(s1,i+1,s2,j+1);
                }
                else{
                    not_choose=can(s1,i+1,s2,j);
                }
                return choose||not_choose;
            }
    }
}