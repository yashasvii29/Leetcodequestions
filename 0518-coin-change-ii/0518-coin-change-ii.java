class Solution {
    public int change(int amount, int coins[]) {
        int dp[][]= new int[amount+1][coins.length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return Coin_Change(coins,amount,0,dp);
    }
    public static int Coin_Change(int coins[],int amount,int i,int dp[][]){

    
        if(amount==0)
            return 1;
        if(i==coins.length){
            return 0;
        }
        if(dp[amount][i]!=-1){
            return dp[amount][i];
        }
        int inc=0,exc=0;
        if(amount>=coins[i]){
              inc=Coin_Change(coins,amount-coins[i],i,dp);

        }
        exc=Coin_Change(coins,amount,i+1,dp);
        return dp[amount][i]= inc+exc;
         
    }
}
// class Solution{
// public static int Coin_Change(int coins[],int amount){
//     // bottom up approach
//     int dp[][]=new int[amount+1][coins.length+1];
//     for(int i=0;i<dp[0].length;i++){
//         dp[0][i]=1;
//     }
//     for(int am=1;am<dp.length;am++){
//         for(int i=1;i<dp[0].length;i++){
//             int inc=0,exc=0;
//         if(am>=coins[i-1]){
//             inc=dp[am-coins[i-1]][i];

//         }
//         exc=dp[am][i-1];
//          dp[am][i]= inc+exc;
         
//         }
//     }
//  return dp[dp.length-1][dp[0].length-1];
// }
// }
 // forward m krenge to dp table starting se fill hona start hogi
        // backward m krenge to dp table last se fill hona start hogi
        // iss que m 2 call lagegi inclusion dp amd exclusion dp
        // if problem ovwerlap hogi then we will use dynamic programming
        // ist call is inclusion and 2nd call is exclusion