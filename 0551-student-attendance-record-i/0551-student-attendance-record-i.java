class Solution {
    public boolean checkRecord(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char key:map.keySet()){
            if(key=='A'){
                if(map.get(key)>1){
                    return false;
                }
            }
            else if(key=='L'){
               if(map.get(key)>2){
                int c=0;
                    for(int i=0;i<s.length();i++){
                        if(s.charAt(i)!='L'){
                            c=0;
                        }
                        if(s.charAt(i)=='L'){
                            c++;
                        }
                        if(c==3){
                            return false;
                        }
                        
                    }
                } 
            }
        }
        return true;
    }
}