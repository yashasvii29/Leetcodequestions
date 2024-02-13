class Solution {
    public boolean hasAlternatingBits(int n) {
        int ans =-1;
        while(n!=0){
            if((n&1)!=ans){
                ans=n&1;
            }
            else{
                return false;
            }
            n>>=1;
        }
        return true;
    }
}