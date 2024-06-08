class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
         HashMap<Integer,Integer> hm  = new HashMap<>();
        hm.put(0,0);
        
       int sum=0;
       
        for( int  i = 0;i < nums.length; i++){
           
            sum+=nums[i];
      
            if(hm.containsKey(sum%k)){
                if(hm.get(sum%k)  < i )
                    return true;
            }else
                hm.put(sum%k, i+1);
            
        }
        return false;
    }
}