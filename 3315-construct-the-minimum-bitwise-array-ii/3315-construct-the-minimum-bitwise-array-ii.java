class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
      int n = nums.size();
      int ans[] = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = getMin(nums.get(i));
        }
        return ans;
    }
    private int getMin(int n){
        if(n < 3)   
            return -1;
        int c = 0;
        int  t = n;
        while((n&1) == 1){
            n >>= 1;
            c++;
        }
        return (t-(1<<(c-1)));
    }
}