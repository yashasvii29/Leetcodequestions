class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return countofSubarray(nums,k);
    }
    public static int countofSubarray(int nums[],int k){
        int si=0;
        int ei=0;
        int ans=0;
        int p=1;
        while(ei<nums.length)
        {
            // window grow
            p*=nums[ei];
            //window small
            while(p>=k && si<=ei){
                p/= nums[si];
                si++;
            }
        // ans calculate
            ans+=ei-si+1;
            ei++;
        }
        return ans;
    }
}