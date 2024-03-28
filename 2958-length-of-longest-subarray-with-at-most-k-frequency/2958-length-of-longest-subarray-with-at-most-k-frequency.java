class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans=0,i=0,j=0;
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            // map.getOrDefault(nums[j],0)..this fun is used to put the default value of key
            while(map.get(nums[j])>k){
                map.put(nums[i],map.get(nums[i])-1);
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
        
    }
}