class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:arr1){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        ArrayList<Integer> ans =new ArrayList<>();
        for(int key:arr2){
            for(int val:map.keySet()){
                if(key==val){
                    int c=map.get(val);
                    while(c-->0){
                        ans.add(val);
                    }
                }
            }
        }
        ArrayList<Integer> ll =new ArrayList<>();
          
        for(int val:arr2){
            ll.add(val);
        }
        for(int key:arr1){
            for(int i=0;i<ll.size();i++){
                if(!ll.contains(key)){
                    ans.add(key);
                    break;
                }
            }
        }
        int res[]=new int[ans.size()];
        for(int i=0;i<res.length;i++){
            res[i]=ans.get(i);
        }
        return res ;
    }
}