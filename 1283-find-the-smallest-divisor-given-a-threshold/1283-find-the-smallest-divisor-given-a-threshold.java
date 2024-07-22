class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
          int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        } 
        int l=1;
        int h=max;
        while(l<=h){
            int mid=(l+h)/2;
            if(findSum(nums,mid)>threshold){
                l=mid+1;
            }
            else{
                h=mid-1;
            }

        } 
        return l;
    }
    public int findSum(int[] nums, int divisor){
        int value=0;
        for(int i=0;i<nums.length;i++){
            value+=Math.ceil((double)nums[i]/divisor);
        }
        return value;
    }
}
