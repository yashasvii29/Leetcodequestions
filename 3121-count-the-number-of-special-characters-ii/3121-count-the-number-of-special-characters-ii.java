class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(Character.isUpperCase(ch) && !map.containsKey(ch)){
                map.put(ch,i);
            }
            else if(Character.isLowerCase(ch) && !map.containsKey(ch)){
                map.put(ch,i);
            }
            else if(Character.isLowerCase(ch) && map.containsKey(ch)){
                map.put(ch,i);
            }
        }
        int c=0;
        for(char key:map.keySet()){
            if(Character.isLowerCase(key)){
                int a=map.get(key);
                char ch=Character.toUpperCase(key);
                for(char val:map.keySet()){
                    if( ch==val && map.get(val)>a){
                    c++;
                }
                }
                
            }
            
            
        }
        return c;
    }
}