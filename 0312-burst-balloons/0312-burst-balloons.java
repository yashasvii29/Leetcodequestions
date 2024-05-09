class Solution {
    public int maxCoins(int[] nums) {
        // this que is same as mcm
        int a[] = new int[nums.length+2];
        for(int i=1;i<=nums.length;i++){
            a[i]=nums[i-1];
        }
        a[0]=a[a.length-1]=1;
       
        return maxCoinsBU(a);
    }
    public static int maxCoinsBU(int arr[]){
        int dp[][]=new int[arr.length][arr.length];
        
        for(int slide = 2;slide < dp.length ; slide++){
            for(int j=slide;j<dp.length;j++){
                int i=j-slide;
                int ans=Integer.MIN_VALUE;
                for(int k=i+1;k<j;k++){
                    int fs=dp[i][k];
                    int ss =dp[k][j];
                    int self=arr[i]*arr[k]*arr[j];
                    ans=Math.max(ans,fs+ss+self); 
                }
                dp[i][j]=ans;

            }
        }
        
        return dp[0][arr.length-1];
    }
}