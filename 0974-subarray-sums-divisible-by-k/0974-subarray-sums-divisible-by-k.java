class Solution {
    public int subarraysDivByK(int[] nums, int k) {
         int ans[]=new int[k];
         ans[0]=1;
         int sum=0;
         for(int i=0;i<nums.length;i++){
             sum+=nums[i];
             sum=sum%k;
             if(sum<0){
                 sum+=k;
             }
             ans[sum]++;
            
         }
         int p=0;
         for(int i=0;i<ans.length;i++){
             if(ans[i]>=2){
                 p=p+((ans[i]*(ans[i]-1))/2);
             }
         }

    return p;
    }
}