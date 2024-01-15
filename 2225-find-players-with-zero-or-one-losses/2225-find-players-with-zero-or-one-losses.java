class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans= new ArrayList<>();
       
        HashMap<Integer,Integer> map =new HashMap<>();

        for(int i=0;i<matches.length;i++){
                int val=matches[i][1];
            if(!map.containsKey(val)){
                map.put(val,1);
            }
            else{
                map.put(val,map.get(val)+1);
            }
        }
        // System.out.println(map);
    HashSet<Integer> set = new HashSet<>();
    //  for(int i=1;i<=10;i++){
    //      if(!map.containsKey(i)){
    //          ls.add(i);
    //      }
    //  }
    for(int i=0;i<matches.length;i++){
        if(!map.containsKey(matches[i][0])){
            set.add(matches[i][0]);
        }
    }
    // System.out.println(set);
     List<Integer> ls = new ArrayList<>(set);
    Collections.sort(ls);
    ans.add(ls);
    set.clear();
    for(int key:map.keySet()){
        if(map.get(key)==1){
            set.add(key);
        }
    }
    List<Integer> ls1 = new ArrayList<>(set);
    Collections.sort(ls1);
    ans.add(ls1);

    return ans;
    }
}