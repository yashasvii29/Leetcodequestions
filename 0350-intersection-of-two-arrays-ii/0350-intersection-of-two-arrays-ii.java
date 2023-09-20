class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Iss que m hume array m unique data return krna hai so we will use map(hashmap)
        // iss que ko O(n) m krna hai
        // har element ke corressponding uski frequency rakhenge in hashmap
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }
            else{
                map.put(nums1[i],1);
            }
        } 
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i])>0){
                list.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        int ans[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;


    }
}