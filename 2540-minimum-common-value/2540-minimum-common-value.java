class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int ans=-1;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums1){
           set.add(i);
        }
        for(int key:nums2){
            if(set.contains(key)){
                ans=key;
                break;
            }
        }
    return ans;
    }
}