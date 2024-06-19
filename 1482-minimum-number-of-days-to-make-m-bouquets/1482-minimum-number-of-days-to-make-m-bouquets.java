class Solution {
    public int minDays(int[] arr, int m, int k) {
       int low=0,high=0,minDays=-1;
        if((m*k)>arr.length)    return minDays;
        for(int item:arr){
            low=Math.min(item,low);
            high=Math.max(item,high);
        }
        while(low<=high){
            int mid=low+((high-low)>>1);
            if(isPossible(mid,arr,m,k)){
                minDays=mid;
                high=mid-1;
            }
            else    low=mid+1;
        }
        return minDays;
    }

     private boolean isPossible(int mid,int arr[],int m,int k){
        int bouqetCnt=0,nosOfFlowers=0;
        for(int item:arr){
            if(item<=mid){
                nosOfFlowers++;
            }
            else    nosOfFlowers=0;
            if(nosOfFlowers==k){
                nosOfFlowers=0;
                bouqetCnt++;
            }
        }
        return (bouqetCnt>=m);
    }
}