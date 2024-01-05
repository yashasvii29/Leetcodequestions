class Solution {
    public int lengthOfLIS(int[] nums) {
        return lis(nums);
        // nlogn =>binary search solution
        // o(n2)=>brute force approach  
    //      ArrayList<Integer>list = new ArrayList<Integer>();
    //     for(int i = 0; i<nums.length; i++)
    //     {
    //       if(list.isEmpty()||list.get(list.size()-1)<nums[i])
    //             list.add(nums[i]);
    //       else if(list.contains(nums[i]))
    //             continue;
    //       else
    //       {
    //         int l = 0,r=list.size()-1;
    //         while(l<=r)
    //         {
    //           int mid = (l+r)/2;
    //           if(list.get(mid)==nums[i])
    //                 break;
    //           else if(list.get(mid)<nums[i])
    //                 l  = mid+1;
    //           else
    //                 r = mid-1;
    //         }
    //         list.set(l,nums[i]);
    //       }
    //     }
    //     return list.size();
    // }
}

public static int lis(int arr[]){
    int dp[]=new int[arr.length];
    Arrays.fill(dp,1);
    for(int i=1;i<dp.length;i++){
        for(int j=i-1;j>=0;j--){
            if(arr[j]<arr[i]){
                int a=dp[j]+1;
                dp[i]=Math.max(dp[i],a);
            }
        }
    }
    int max=dp[0];
    for(int i=1;i<dp.length;i++){
        if(max<dp[i]){
            max=dp[i];
        }
    }
    return max;
    }
}