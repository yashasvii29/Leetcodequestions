class Solution {
    public int minOperations(int[] nums) {
          Arrays.sort(nums);
// using 2 pointers apprach
        int res = 0;
        int si = 0;
        while(si < nums.length){
            int ei = si;
            
            while(ei < nums.length && nums[ei] == nums[si]) {
                ei++;
            }
            int count = ei-si;
            if(count == 1)
                 return -1;
            res += count/3;

            if(count%3 != 0) res++;
            si=ei;
        }
        return res;
    }
}