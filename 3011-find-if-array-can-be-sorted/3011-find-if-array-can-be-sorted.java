class Solution {
    public boolean canSortArray(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                 int ans = Integer.bitCount(nums[j]);
                    int ans1 = Integer.bitCount(nums[j + 1]);
                    if(ans==ans1){     
                         int t=nums[j];
                         nums[j]=nums[j+1];
                         nums[j+1]=t;                   
                    }
                     
                }
            }
        }  
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                   return false;
            }    
        }
        return true;
    }
}


  //         while(nums[j]>0){
                //             nums[j]=(nums[j]&(nums[j]-1));
                            
                //                 ans++;

                //         }
                //     
                //         while(nums[j+1]>0){
                //             nums[j+1]=(nums[j+1]&(nums[j+1]-1));
                            
                //                 ans1++;
                            

                //         }