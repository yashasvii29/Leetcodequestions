class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ls=new ArrayList<>();
        for(int a:nums){
            ls.add(a);
        }
        int ans=-1;
        for(int i=nums.length-1;i>=0;i--){
            int val=nums[i];
            if(val>0 && ls.contains(-val)){
                ans=val;
                break;
            }
        }
        return ans;
    }
}