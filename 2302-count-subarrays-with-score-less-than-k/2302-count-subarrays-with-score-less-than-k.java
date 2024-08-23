class Solution {
    public long countSubarrays(int[] nums, long k) {
         return countofSubarray(nums,k);
    }
    public static long countofSubarray(int nums[],long k){
        int si=0;
        int ei=0;
        long ans=0;
        long sum = 0;
       
        long score=0;
        while(ei<nums.length)
        {
            // window grow
            sum+=nums[ei];
            score=sum*(ei-si+1);
        
            
            //window small
            while(score>=k && si<=ei){
                sum-= nums[si];
                si++;
                score = sum * (ei - si + 1); // Recalculate score after shrinking
            }
        // ans calculate
            ans+=ei-si+1;
            ei++;
        }
        return ans;
    }
}