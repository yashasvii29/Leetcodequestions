class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int len=0;
        boolean flag=false;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                int c=0;
                if(s.charAt(i)==s.charAt(j)){
                    flag=true;
                    c=j-i-1;
                    len=Math.max(len,c);
                }
            }
        }
        if(flag==false){
            return -1;
        }
        return len;
    }
}