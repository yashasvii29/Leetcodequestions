class Solution {
    public String lastNonEmptyString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
       
      
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }
               else{
                   map.put(ch,map.get(ch)+1);
               }
        }
            int maxfreq=0;
               for(char key:map.keySet()){
                  maxfreq=Math.max(map.get(key),maxfreq);
               }

                StringBuilder sb = new StringBuilder();


           // Loop through the string from the right side
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (map.get(ch) == maxfreq) {
                sb.insert(0, ch); // Insert character at the beginning of the StringBuilder
                // Decrease the frequency count to avoid duplicate characters
                map.put(ch, map.get(ch) - 1);
            }
        }
               return sb.toString();
    }
}