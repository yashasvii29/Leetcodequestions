class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
       
        long c=0;
        int even=1;
        int odd=0;
        long sum=0;
        
        
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            
            if(sum%2==0){
                c+=odd;
                even++;
            }else{
                c+=even;
                odd++;
            }
        }
        
        return (int)(c%(1000000007));
    }
}