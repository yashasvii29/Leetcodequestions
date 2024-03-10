class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int ans[]=new int[nums.length];
        List<Integer> ll = new ArrayList<>();
        List<Integer> rl = new ArrayList<>();
        for(int i:nums){
            if(i<pivot){
                ll.add(i);
            }
            else if(i>pivot){
                rl.add(i);
            }
        }
        int size = nums.length - (ll.size()+rl.size());
    int j=0;
        for(int i=0;i<ll.size();i++){
            ans[j++]=ll.get(i);
        }
        if(size>0){
             while(size>0){
            ans[j++]=pivot;
            size--;
        }
        }
       int k=0;
        for(int i=j;i<nums.length;i++){
            ans[j++]=rl.get(k);
            k++;
        }
        return ans;
    }
}