class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3){
            return false;
        }
        int c=0;
        for(int i=0;i<arr.length-2;i++){
            if(arr[i]%2!=0){
                c++;
                if(c==3){
                    return true;
                }
            }
            else{
                c=0;
            }
        }
        // c=0;
        int n=arr.length;
        for(int j=n-2;j<arr.length;j++){
            if(arr[j]%2!=0){
                c++;
            }
            if(c==3){
                return true;
            }
        }
        return false;
    }
}