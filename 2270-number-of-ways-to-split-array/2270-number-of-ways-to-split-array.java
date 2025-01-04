class Solution {
    public int waysToSplitArray(int[] nums) {
        int c=0;
        int n=nums.length;
        long prefix[]=new long[nums.length];
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            prefix[i]=sum;
        }

        for(int i=0;i<n-1;i++){
            if(prefix[i]>=prefix[n-1]-prefix[i]){
                c++;
            }
        }
        return c;
    }
}