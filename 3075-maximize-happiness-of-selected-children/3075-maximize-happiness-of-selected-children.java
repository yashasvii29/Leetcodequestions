class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        
        int n = happiness.length;
        Arrays.sort(happiness);
        long pick=0,ans=0;
        int i=n-1;
        while(k-->0){
            if(happiness[i]-pick<0){
        //   -ve value aate hi ans return kr denge               
                return ans;
            }
            ans+=(long)happiness[i]-pick;
            pick++;
            i--;
        }
        return ans;
        
    }
}