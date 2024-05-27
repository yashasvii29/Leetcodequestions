class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<=nums.length;i++){
            if(!map.containsKey(i)){
                int c=0;
                for(int num:nums){
                    if(num>=i){
                        c++;
                    }
                }
                map.put(i,c);
            }
        }
        for(int key:map.keySet()){
            if(map.get(key)==key){
                return key;
            }
        }
        return -1;
    }
}