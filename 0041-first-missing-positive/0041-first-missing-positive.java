class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val:nums){
            if(!map.containsKey(val)){
                map.put(val,1);
            }
            map.put(val,map.get(val)+1);
        }
        for(int i=1;i<=Integer.MAX_VALUE;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
      return 1;  
    }
}