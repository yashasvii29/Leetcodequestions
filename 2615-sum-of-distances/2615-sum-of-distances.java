class Solution {
    public long[] distance(int[] nums) {
        // brute force O(n2)...it gives tle
    //      int n = nums.length;
    //     long[] arr = new long[n];
    //   for(int i=0;i<nums.length;i++){
    //     int sum=0;
    //     for(int j=0;j<n;j++){
    //         if(i!=j && nums[j]==nums[i]){
    //             sum+=Math.abs(i-j);
    //         }
    //     }
    //     arr[i]=sum;
    //   }

    //     return arr;



    // optimise code
         int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int curr = nums[i];
            if(!map.containsKey(curr)){
                map.put(curr, new ArrayList<>());
            }
            
            map.get(curr).add(i);
        }
        
        for(Integer key: map.keySet()){
            int currVal = key;
            List<Integer> indices = map.get(currVal);
            if(indices.size()==1){
                ans[indices.get(0)] = 0;
                continue;
            }
            
            n = indices.size();
            long sum = 0;
            for(int i=0;i<n;i++){
                sum += indices.get(i);
            }
            long leftSum = 0;
            long rightSum = sum;
            long currAns = 0;
            for(int i=0;i<n;i++){
                currAns = 0;
                currAns += (long)i*(long)indices.get(i) - leftSum;
                currAns += rightSum - (long)(n-i)*(long)indices.get(i);
                leftSum += (long)indices.get(i);
                rightSum -= (long)indices.get(i);
                ans[indices.get(i)] = currAns;
                
            }
            
        }
        return ans;
    }
}