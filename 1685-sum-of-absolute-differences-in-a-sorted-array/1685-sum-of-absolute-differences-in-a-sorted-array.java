class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int lfsum=0,rtsum=0;
        for(int s:nums){
            rtsum+=s;
        }
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=nums[i]*((i<<1)-nums.length)-lfsum+rtsum;
            lfsum+=nums[i];
            rtsum-=nums[i];
        }
        return ans;
    }
}