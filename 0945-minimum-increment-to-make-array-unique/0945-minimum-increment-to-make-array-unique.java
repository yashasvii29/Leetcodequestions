class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
       int prev=-1;
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(prev>=nums[i]){
                c=c+(prev-nums[i]+1);
                nums[i]=prev+1;
            }
            // nums[i] previous ban jayega
            prev=nums[i];
        }
        return c;
    }
}