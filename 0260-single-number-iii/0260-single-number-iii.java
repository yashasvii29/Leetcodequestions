class Solution {
    public int[] singleNumber(int[] nums) {
        // brute force using hashmap
        // Arrays.sort(nums);
        
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int val:nums){
        //     if(!map.containsKey(val)){
        //         map.put(val,1);
        //     }
        //     else{
        //         map.put(val,map.get(val)+1);
        //     }
        // } 
        // int c=0;
        // for(int key:map.keySet()){
        //     if(map.get(key)==1){
        //         res[c++]=key;
                
        //     }
        // }
       
        // return res;


        // optimise solution using bitmasking
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans=ans^nums[i];
        }
        int mask = ans & (~(ans-1));
        int[] res = new int[2];
        int a=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i] & mask) != 0){
                a=a^nums[i];
            }
        }
         res[0]=a;
        int b = ans ^ a;
       
        res[1]=b;
        return res;

    }
}