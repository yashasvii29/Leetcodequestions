class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int ans=Integer.MIN_VALUE;
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(int a[]:dp){
            Arrays.fill(a,0);
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    ans=Math.max(ans,findMax(matrix,i,j,dp));
                }
            }
        }
        return ans==Integer.MIN_VALUE ? 0 : ans*ans;
    
    }

    private static int findMax(char[][] matrix,int i,int j,int dp[][]){
        if(i>=matrix.length || j>=matrix[0].length || i<0 || j<0 ||matrix[i][j]=='0'){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }

        int ver = findMax(matrix,i+1,j,dp);

        int hor = findMax(matrix,i,j+1,dp);

        int diag = findMax(matrix,i+1,j+1,dp);

        return dp[i][j]=1+Math.min(ver,Math.min(hor,diag));
    }






}
