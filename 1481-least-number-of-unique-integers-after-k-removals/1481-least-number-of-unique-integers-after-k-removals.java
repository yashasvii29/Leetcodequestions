class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
       int n = arr.length;
    int[] count = new int[n];
    HashMap<Integer, Integer> map = new HashMap<>(n);
    int j = -1;
    for(int a : arr){
        if(!map.containsKey(a))
            map.put(a, ++j);
        count[map.get(a)]++;
    }
    if(k == 0) return j + 1;
    Arrays.sort(count);
    for(int i = 0; i < count.length; i++){
        if(count[i] < k)
            k -= count[i];
        else if(count[i] == k)
            return count.length - i - 1;
        else
            return count.length - i;
    }
    return 0;
       
    }
     
}