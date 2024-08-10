class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int key:barcodes){
            map.put(key,map.getOrDefault(key,0)+1);
        }

        ArrayList<Integer> keys=new ArrayList<>(map.keySet());

         Collections.sort(keys, (a, b) -> map.get(b) - map.get(a));
        //  sort the keys in descending order
       int i=0;
       int n=barcodes.length;
       for(int key:keys){
        int count=map.get(key);
        while(count-->0){
            barcodes[i]=key;
            i+=2;
            if(i>=n){
                i=1;
            }
        }
       }
       return barcodes;
    }
}