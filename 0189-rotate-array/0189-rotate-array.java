class Solution {
    public void rotate(int[] nums, int k) {
          k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] arr,int s,int e)
    {
        while(s<=e)
        {
            int t=arr[s];
            arr[s]=arr[e];
            arr[e]=t;
            s++;
            e--;
        }
    }
}


// rotate the array left

        // k=k%nums.length;
        // reverse(nums,0,k-1);
        //  reverse(nums,k,nums.length-1);
        // reverse(nums,0,nums.length-1);
       
