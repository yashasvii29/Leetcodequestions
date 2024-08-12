class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> ll=new ArrayList<>();
        
//          Arrays.sort(nums);
//          int n=nums.length;
//          for(int i=0;i<n-2;i++){
//               for(int j=i+1;j<n-1;j++){
//                   for(int k=j+1;k<n;k++){
//                       if(nums[i]+nums[j]+nums[k]==0){
//                            List<Integer> ans=new ArrayList<>();
//                          ans.add(nums[i]);
//                            ans.add(nums[j]);
//                             ans.add(nums[k]);
//                             if(!ll.contains(ans))
//                                 ll.add(ans);
//                       }
//                   }
//               }
//          }
//          return ll;
//     }
//     // this is brute force approach and time complexity is O(n3) and space complexity is O(n2)  but we will do this question in O(n2) time complexity and space com is O(n)
// }

 List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
         for(int  i = 0; i<n ; i++ ){
             if(i > 0 && nums[i] == nums[i-1]){
                // adjacent element same hai toh continue krenge
                 continue;
             }
             int j =i+1;
             int k = n-1;
            while(j<k){
             int sum = nums[i] + nums[j] + nums[k];

             if(sum<0){ // sum is -ve
                 j++;
             }
             else if(sum>0){  // sum is +ve
                 k--;
             }
             else {  // sum == 0
                   List<Integer> ll=new ArrayList<>();
                   ll.add(nums[i]);
                   ll.add(nums[j]);
                    ll.add(nums[k]);
                   ans.add(ll);
                   j++;
                   k--;
                   while(k>j &&nums[k]== nums[k+1]){
                        k--;
                   }
                   while(k>j && nums[j]== nums[j-1]){
                        j++;
                   }
             }
            }
         }
         return ans;
    }
}
// in this two pointers approach time complexity will be O(nlogn)+O(n2)
//space complexity will be O(1)
// in this code i is fixed pointer and j and k are moving