class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n=nums.length;
        int ans[]=new int[queries.length];
        int j=0;


        for(int a[]:queries){
            int val=a[0];
            int idx = a[1];
            nums[idx]=nums[idx]+val;
            int sum=0;
            for(int num:nums){
                if(num%2==0){
                    sum+=num;
                }
            }
            ans[j++]=sum ;
        }
        return ans;
    }
}