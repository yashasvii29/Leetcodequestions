class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n=nums1.length;
        int m=nums2.length;
        int ans[]=new int[2];
        int c=0;
        for(int i=0;i<n;i++){
            int ele=nums1[i];
            for(int j=0;j<m;j++){
                if(nums2[j]==ele){
                    c++;
                    break;
                }
                else if(nums2[j]>ele){
                    break;
                }
            }
        }
        ans[0]=c;
        c=0;
          for(int i=0;i<m;i++){
            int ele=nums2[i];
            for(int j=0;j<n;j++){
                if(nums1[j]==ele){
                    c++;
                    break;
                }
                else if(nums1[j]>ele){
                    break;
                }
            }
        }
        ans[1]=c;
        return ans;
    }
}