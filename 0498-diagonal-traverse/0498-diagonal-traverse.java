class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int ans[]=new int[m*n];
        int i=0;
        for(int d=0;d<m+n-1;d++){ // d ->  jitne diagonal hai utne times loop chalega
            int r=0;
            int c=0;


// hamesha top se bottom elements ko add krenge
            // sabse pehle col ke liye condition check krenge
            if(d<n){
                // if diagonal chota h col ki len se so row hamesha initially 0 hogi and col m d assign k denge
                r=0;
                c=d;
            }
            else{
                r=d-n+1;
                c=n-1;
            }
            ArrayList<Integer> ll=new ArrayList<>();
            // arrayll m diagonal ka element rakh rahe h
            // each diagonal ke liye new ll banegi
            while(r<m &&c>=0){
                // hamesha top se bottom elements ko add krenge toh row ko increase krenge and col ko decrease
                ll.add(mat[r][c]);
                r++;
                c--;
            }
            // hum top se bottom elements ko add kr rhe h if diagonal even h toh list ko reverse kr denge
            if(d%2==0){
                // if even diagonal h means  diagonal 2 se divisible ho rha h so ll ko reverse kr denge
                Collections.reverse(ll);
            }
            // ll m enhance for loop chalayenge and ans array m val ko add krte jayenge
            for(int val:ll){
                ans[i++]=val;
                
            }
        }
        return ans;
    }
}
        