class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int c=0;
    
        for(int i=0;i<=nums.length-k;i++){
            int j=i;
            int sum=0;
                int t=0;
            while(t!=k){
                sum+=nums[j++];
                t++;

            }
            int avg = sum/k;
            if(avg>=threshold){
               c++;
            }
        }
        return c;
    }
}