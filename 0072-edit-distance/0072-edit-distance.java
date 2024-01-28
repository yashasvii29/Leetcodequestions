class Solution {
    public int minDistance(String word1, String word2) {
        // this que is same as lcs
        // iss que m 2 string given hai and 1st string ko 2nd string m convert krna hai means 1st string se 2nd string banani hai(sabhi operations 1st string m apply krne hai) with minimum no. of operations
        // we have to return minimum no. of operations
    
        // int dp[][]=new int[word1.length()][word2.length()];
        // for(int a[]:dp){
        //     Arrays.fill(a,-1);
        // }
        return Edit(word1,word2);
    }
//     public static int Edit(String s1,String s2,int i,int j,int dp[][]){
//         // base case
//         if(i==s1.length()){ //mEANS First STRING empty ho gyi
//             return s2.length()-j;
//         } 
//         if(j==s2.length()){
//             // means sECONd str khali ho gyi 
//             return s1.length()-i;
//         }
//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }
//         int ans=0;
//         if(s1.charAt(i)==s2.charAt(j)){
//             // dono string ka char match kr rha hai toh 1 recursive call
//             // char match kr rha hai
//             ans=Edit(s1,s2,i+1,j+1,dp);
//         }
//         else{
//              // dono string ka char match nhi kr rha hai toh 3 recursive call
//             // char mismatch kr rha hai so we have3 choices
//             // delete
//             int d=Edit(s1,s2,i+1,j,dp);
//              // insert
//             int in=Edit(s1,s2,i,j+1,dp);
//             // replace
//             int r=Edit(s1,s2,i+1,j+1,dp);
//         //    har frame se inn tenno ka minimum + 1 return krenge ... 1 isliye bcz 1 operation toh apply kr rhi rhe hai
//             ans=Math.min(d,Math.min(in,r))+1;

//         }
//         dp[i][j]=ans;
//         return ans;
//     }
// }

// bottom up approach...hum top down approach ke code  ki help se bottom up ka code likh sakte hai
public static int Edit(String s1,String s2){
    int dp[][] = new int[s1.length()+1][s2.length()+1];
    for(int i=1;i<dp[0].length;i++){
        dp[0][i]=i;
    }
    for(int i=1;i<dp.length;i++){
        dp[i][0]=i;
    }

    for(int i=1;i<dp.length;i++){
        for(int j=1;j<dp[0].length;j++){
            int ans=0;
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans=dp[i-1][j-1];
            }
            else{
                int delete = dp[i-1][j];
                int insert = dp[i][j-1];
                int replace = dp[i-1][j-1];
                ans=Math.min(delete,Math.min(insert,replace))+1;
            }
            dp[i][j]=ans;

        }
        
    }
    return dp[s1.length()][s2.length()];
}
}