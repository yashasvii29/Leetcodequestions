class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        int st=0,end=n-1;
        while(st<end)
        {
            char t=s[st];
            s[st]=s[end];
            s[end]=t;
            st++;
            end--;
        }
    
    }
}