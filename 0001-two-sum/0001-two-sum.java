class Solution
{
    public int[] twoSum(int[] nums, int target) 
  {
    // brute force approach O(n2)
    // int n=nums.length;
    // int[] res=new int[2];
    // for(int i=0;i<n-1;i++)
    // {
    //     for(int j=i+1;j<n;j++)
    //     {
    //         if(nums[i]+nums[j]==target)
    //         {
    //             res[0]=i;
    //             res[1]=j;
    //         }
    //     }
            
    // } 
    //     return res;




    // optimise code O(n)
    int n=nums.length;
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i=0;i<n;i++){
        int val = target-nums[i];
        if(map.containsKey(val)){
            return new int[]{i,map.get(val)};
        }
        map.put(nums[i],i);
    } 
    return new int[0];
  } 
    
}
    