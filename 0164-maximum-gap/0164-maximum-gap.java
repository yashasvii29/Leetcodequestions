class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        int i=0,j=1;
        while(i<j && j<nums.length){
             max=Math.max(nums[j]-nums[i],max);
            i++;
            j++;
        }
        return max;
    }
}