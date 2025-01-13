class Solution {
    public int minimumLength(String s) {
        if(s.length()<3){
            return s.length();
        }
        HashMap<Character,Integer> map=new HashMap<>();

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int minlen=0;
           
                for (int val : map.values()) {
                // Simulate removing characters from both ends
                while (val > 2) {
                    val -= 2;
                }
                // Add the remaining value to minlen
                minlen += val;
            }
        
        return minlen;
    }
}