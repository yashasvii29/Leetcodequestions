class Solution {
    public int checkRecord(int n) {
        int dp[][][]=new int[n+1][2][3];
        return check(n,0,0,dp);
    }
    static int mod=1000000007;
    public static int check(int n,int A,int L,int dp[][][]){
         if (n == 0)
            return 1;

        if (dp[n][A][L] != 0)
            return dp[n][A][L];
        int count = check(n - 1, A, 0, dp) % mod;

        if (L < 2) {
            count = (count + check(n - 1, A, L + 1, dp)) % mod;
        }

        if (A < 1) {
            count = (count + check(n - 1, A + 1, 0, dp)) % mod;
        }
        return dp[n][A][L] = count;
    }
}