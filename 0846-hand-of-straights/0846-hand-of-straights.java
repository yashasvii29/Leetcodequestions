class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
     
        Arrays.sort(hand);

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:hand){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
           
         for (int val : hand) {
            if (map.get(val) > 0) {
                // Try to form a group starting with val
                for (int i = 0; i < groupSize; i++) {
                    int key = val + i;
                   if (map.get(key) == null || map.get(key) == 0) {
                        return false;
                    }
                    map.put(key, map.get(key) - 1);
                }
            }
        }
           
     
        return true;
    }
}