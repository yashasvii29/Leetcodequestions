class Solution {
    public int jump(int[] nums) {
           int cur= 0;
           int c=0;
           int reach=0;
       for(int i = 0; i < nums.length-1; i ++) {
         
           reach = Math.max(reach, i + nums[i]);
           if(i==cur){
            cur=reach;
             c++;
           }
                
       } 
       return c;
    }
}