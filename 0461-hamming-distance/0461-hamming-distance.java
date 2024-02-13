class Solution {
    public int hammingDistance(int x, int y) {
        // last bit check krenge x and y ki
        int c = 0;
        int max =Math.max(x,y);
        while(x!=0 || y!=0){
            if((x&1)!=(y&1)){
                // means if x and y ki last bit equal nhi hai then c++
                c++;
            }
            // x and y dono ki last bit ko drop kr denge
            x>>=1;
            y>>=1;
            
        }
        return c;
    }
}