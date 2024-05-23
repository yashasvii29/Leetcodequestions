class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
         List<Integer> ll=new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Subset(nums,0,ll,ans,k);
        return ans.size();
        
    }
    static int c=0;
    public static void Subset(int arr[],int i,List<Integer> ll,List<List<Integer>> ans,int k){
        if(i==arr.length){
            if(ll.size()>0)
                ans.add(new ArrayList<Integer>(ll));
            return;
        }
        Subset(arr,i+1,ll,ans,k);
        if(!ll.contains(arr[i]-k)){
        ll.add(arr[i]);
        Subset(arr,i+1,ll,ans,k);
        ll.remove(ll.size()-1);
        }
            
    }
}