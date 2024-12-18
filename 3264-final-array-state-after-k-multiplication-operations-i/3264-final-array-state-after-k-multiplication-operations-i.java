class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k-->0){
    
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            for(int i=0;i<nums.length;i++){
                pq.add(nums[i]);
            }
            int ele=pq.poll();
    int j=0;
            while(j<nums.length){
                if(nums[j]==ele){
                    nums[j]=nums[j]*multiplier;
                    break;
                }
                j++;
            }
        }      
        
        return nums;
    }
}