class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }
            else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        List<Integer> ls = new ArrayList<>();

        for(int key:map.keySet()){
            ls.add(map.get(key));
        }
        HashSet<Integer> set = new HashSet<>();
        for(int val:ls){
            set.add(val);
        }
        if(ls.size()!=set.size()){
            return false;
        }
        return true;

    }
}