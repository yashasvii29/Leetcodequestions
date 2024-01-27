class Solution {
    public String kthLargestNumber(String[] nums, int k) {
   
         Arrays.sort(nums, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length() != b.length()){
                     return a.length() - b.length();
                }
                return a.compareTo(b);
            }
        });
        return nums[nums.length-k];



// the first approach gives runtime error 

    // PriorityQueue<Long> pq=new PriorityQueue<>();
    // for(int i=0;i<k;i++){
    //     pq.add(Long.parseLong(nums[i]));
    // }
    // for(int i=k;i<nums.length;i++){
    //     if(Long.parseLong(nums[i])>pq.peek()){
    //         pq.poll();
    //         pq.add(Long.parseLong(nums[i]));
    //     }

    
    // }
    // return pq.peek().toString();
  }

}    




