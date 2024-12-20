class Solution {
    public String convert(String s, int numRows) {
        // overall tc is O(m+n)
        if(numRows==1){
            return s;
        }

        List<List<Character>> ll = new ArrayList<>();
        // time complexity O(n)
        for(int i=0;i<numRows;i++){
            ll.add(new ArrayList<>());
        }

        int dir=1, curRow=0;


        // time complexity of this loop is O(m)
        for(char ch:s.toCharArray()){
            ll.get(curRow).add(ch);
            if(curRow==numRows-1){
                dir=-1;
            }
            else if(curRow==0){
                dir=1;
            }
            curRow+=dir;
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ll.size();i++){
            // first list pr iterate krenge inside the enhance for loop
            for(char ch:ll.get(i)){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}