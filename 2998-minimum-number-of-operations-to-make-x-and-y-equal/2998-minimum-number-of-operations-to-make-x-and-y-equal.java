class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
       if(x<=y) 
            return y-x;
        int a=Math.abs(x-y);
         a=Math.min(a, 1+x%11 + minimumOperationsToMakeEqual(x/11,y));
        a=Math.min(a, 1+11-x%11 +minimumOperationsToMakeEqual(x/11+1,y));
        a=Math.min(a, 1+x%5 + minimumOperationsToMakeEqual(x/5,y));
        a=Math.min(a, 1+5-x%5 + minimumOperationsToMakeEqual(x/5+1,y));
       
        return a;
    }

}