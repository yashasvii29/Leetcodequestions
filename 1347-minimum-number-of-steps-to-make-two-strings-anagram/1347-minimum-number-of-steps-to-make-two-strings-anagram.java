class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
     HashMap<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(map1.containsKey(ch)){
                map1.put(ch,map1.get(ch)+1);
            }
            else{
                map1.put(ch,1);
            }
        }
        int c=0;
        for(char key:map.keySet()){
            if(map1.containsKey(key)){
                c+=Math.min(map.get(key),map1.get(key));
            }
        }
        return s.length()-c;

    }
}