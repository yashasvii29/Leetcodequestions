class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        
        int ans[]=new int[2];
        for(int val:map.keySet()){
            if(map.get(val)>1){
                ans[0]=val;
                
            }
            
        }
    int start=1;
        while(start<=nums.length){
            if(map.containsKey(start)){
                start++;
                continue;
            }
            else{
                ans[1]=start;
                break;
            }
        }
       return ans; 
    }
}