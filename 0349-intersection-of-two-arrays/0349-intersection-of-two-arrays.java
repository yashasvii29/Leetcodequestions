class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!list1.contains(nums1[i])) {
                list1.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            
            if (list1.contains(nums2[i]) && !ans.contains(nums2[i])) {
                ans.add(nums2[i]);
            }
        }
        int[] a = new int[ans.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = ans.get(i);
        }
        return a;
    }
}