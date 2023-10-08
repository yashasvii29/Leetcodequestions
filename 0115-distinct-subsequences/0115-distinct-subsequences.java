class Solution {
    public int numDistinct(String s, String t) {
        // this que is same as coin change
        int dp[][]=new int[t.length()+1][s.length()+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        
    return DistinctSubse(s,t,0,0,dp);
    }

    // s1-->coin
    //t1-->amount
    //i-->s1 ka index
    //j--> t1 ka index

    public static int DistinctSubse(String s1,String t1,int i,int j,int dp[][]){
        if(i==t1.length())
            return 1;
        if(j==s1.length())
            return 0;
        if(dp[i][j] !=-1){
            return dp[i][j];
        }
        int inc=0,exc=0;
        if(s1.charAt(j)==t1.charAt(i)){
            inc=DistinctSubse(s1,t1,i+1,j+1,dp);
        }
        exc=DistinctSubse(s1,t1,i,j+1,dp);
        dp[i][j]=inc+exc;
        return inc+exc;
    }
}