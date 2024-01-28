class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int[] a:dp){
            Arrays.fill(a,Integer.MIN_VALUE);
        }

        int x=solve(nums1,nums2,0,0,dp);

        if(x==0){
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            if(nums1[0]<0){
                return nums1[nums1.length-1]*nums2[0];
            }else{
                return nums2[nums2.length-1]*nums1[0];
            }
        }
        return x;
    }
    public int solve(int[] nums1,int[] nums2,int i,int j,int[][] dp){
        if(i==nums1.length || j==nums2.length){
            return 0;
        }
        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }
        int pickboth=(nums1[i]*nums2[j])+solve(nums1,nums2,i+1,j+1,dp);
        int pick1=solve(nums1,nums2,i,j+1,dp);
        int pick2=solve(nums1,nums2,i+1,j,dp);
        
        return dp[i][j]=Math.max(pickboth,Math.max(pick1,pick2));
    }
}