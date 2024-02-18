class Solution {
    public int singleNumber(int[] nums) {

        // optimise code using bitmasking 
        // tc = O(n)...sc = O(1)
        int ans =0;
        for(int i=0;i<32;i++){
            int ones =0;
            for(int n:nums){
                ones += (n>>i)&1;
            }
            ones = ones % 3;

             // making ans by seting the ith bit set 
            // taking | (or) because it add the decimal if both are different

            ans = ans | ones<<i;
        }
        return ans;
    }
}


    //     int ans =1;
    //     for(int i=1;i<=nums.length;i++){
    //         ans=ans^i;       
    //  }
    //  for(int i=0;i<nums.length;i++){
    //      ans=ans^nums[i];
    //  }
    //  return ans;
        
    //     Arrays.sort(nums);
    //     if(nums.length==1){
    //         return nums[0];
    //     }
    //     for(int i=0;i<nums.length-1;i+=3){
    //         if(nums[i]!=nums[i+1]){
    //             return nums[i];
    //         }
    //     }
    //    return nums[nums.length-1];
    // HashMap<Integer,Integer> map = new HashMap<>();
    // for(int val:nums){
    //     if(!map.containsKey(val)){
    //         map.put(val,1);
    //     }
    //     else{
    //         map.put(val,map.get(val)+1);
    //     }
    // } 
    // int ans=0;
    // for(int key:map.keySet()){
    //     if(map.get(key)==1){
    //         ans=key;
    //         break;
    //     }
    // }
    // return ans;
