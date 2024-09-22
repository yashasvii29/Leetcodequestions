class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
       HashSet<String> set = new HashSet<>();
       for(String s:bannedWords){
        set.add(s);
        
       }
    int c=0;
       for(String  str:message){
        if(set.contains(str)){
            c++;
        }
       }

       return c>1 ? true : false;
    }
}