class Solution {
    public int[] findArray(int[] pref) {
        int arr[]=new int[pref.length];
        arr[0]=pref[0];
        for(int i=1;i<arr.length;i++){
            arr[i]=pref[i]^pref[i-1];
        }
        return arr;
    }
}