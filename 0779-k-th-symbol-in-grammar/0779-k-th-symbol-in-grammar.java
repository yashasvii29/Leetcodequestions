class Solution {
    public int kthGrammar(int n, int k) {
        return helper(n,k);
    }
    private int helper(int n,int k){
        if(n==1 && k==1)
                return 0;
        int mid = (int) Math.pow(2,n-1);
        mid=mid/2;

        if(k<=mid){
            return helper(n-1,k);
        }
        else{
            int ans=helper(n-1,k-mid);
            return (ans==0) ? 1 : 0;

        }
    }
}