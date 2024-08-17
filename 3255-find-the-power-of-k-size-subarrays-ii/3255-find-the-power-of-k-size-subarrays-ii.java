class Solution {
    public int[] resultsArray(int[] nums, int k) {
         int n=nums.length;
        int ans[]=new int[n-k+1];
        if(k==1){
        return nums;
        }
        if(n<k){
            return new int[0];
        }
        int c=1;
        Arrays.fill(ans, -1);
        for(int i=1; i<n; i++)
        {
            if(nums[i] != nums[i-1]+1)
                c = 1;
            else
            {
                c++;
                if(c >= k)
                    ans[i-k+1] = nums[i];
            }
        }
        return ans;
    }
}