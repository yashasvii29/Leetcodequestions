class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length-k];
       PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());
    for(int i=0;i<nums.length;i++){
        pq.add(nums[i]);
    }
    // for(int i=k;i<nums.length;i++){
    //     if(nums[i]>pq.peek()){
    //         pq.poll();
    //         pq.add(nums[i]);
    //     }

    
    // }
 
    while(k-->1){
         pq.poll();
    }
    return pq.peek();

    }


}