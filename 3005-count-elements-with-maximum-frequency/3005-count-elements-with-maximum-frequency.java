class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        int c=0;
        for(int key:map.keySet()){
            c=Math.max(c,map.get(key));
        }
        int ans=0;
        for(int var:map.keySet()){
            if(c==map.get(var)){
                ans=ans+map.get(var);
            }
            
        }
        return ans;
    }
}