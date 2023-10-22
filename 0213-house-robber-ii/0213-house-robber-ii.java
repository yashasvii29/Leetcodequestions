class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        int[] a=new int[nums.length-1];
        int[] b= new int[nums.length-1];
        
        for(int i=0;i<nums.length-1;i++){
            a[i]=nums[i+1];
            b[i]=nums[i];
        }
        
     int x =  robUtil2(a,a.length-1,dp); 
     int y = robUtil2(b,b.length-1,dp); 
    return Math.max(x,y);
        
    }
    
    public static int robUtil2(int[] arr,int ind,int[] dp){
        
        
      int n = arr.length;
    int prev = arr[0];
    int prev2 =0;
    
    for(int i=1; i<n; i++){
        int pick = arr[i];
        if(i>1)
            pick += prev2;
        int nonPick = 0 + prev;
            int cur_i = Math.max(pick, nonPick);
        prev2 = prev;
        prev= cur_i;
        
    }
    return prev;
    }
}
