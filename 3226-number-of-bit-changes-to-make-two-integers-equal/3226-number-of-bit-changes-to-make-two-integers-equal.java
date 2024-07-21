class Solution {
    public int minChanges(int n, int k) {

        if(n==k){
            return 0;
        }
       int c = 0;
        while(n!=k){
            int n1=n&1;
            int k1=k&1;
            if(n1==1 && k1==0){
                c++;
            }
            else if(n1==0 && k1==1){
                return -1;
            }
            n=n>>1;
            k=k>>1;
        }
       return c;
    
    }
}