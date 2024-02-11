class Solution {
    public int[] countBits(int n) {
        int arr[]=new int[n+1];  
        for(int i=0;i<arr.length;i++){
            arr[i]=FastCount(i);
        }
        return arr;
    }


    public static int FastCount(int n){
    // optimise solution of count set bit 
        int c=0;
       
        while(n>0){
            n=n&(n-1);
            c++;
        }
        return c;
   }
   
}