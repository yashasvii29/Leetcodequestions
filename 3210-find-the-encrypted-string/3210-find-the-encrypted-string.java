class Solution {
    public String getEncryptedString(String s, int k) {
        String ans="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt((i+k)%s.length());
            ans+=ch;
        }
        return ans;
    }
}