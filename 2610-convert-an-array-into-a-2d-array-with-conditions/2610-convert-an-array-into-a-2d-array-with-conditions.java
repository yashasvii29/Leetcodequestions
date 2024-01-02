class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
       
       
        int c=0;

        while(c!=nums.length){
            List<Integer> ll = new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]!=0 && !ll.contains(nums[i])){
                    ll.add(nums[i]);
                    nums[i]=0;
                    c++;
                }
            }
            if(ll.size()==0)
                break;
            ans.add(ll);        
            
        }
    return ans;
    }
}