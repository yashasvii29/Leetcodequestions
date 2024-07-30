class Solution {
    public int minimumCardPickup(int[] cards) {
        boolean flag=false;
        int ei=0;
        int si=0;
        int s= Integer.MAX_VALUE;
        char ch[]=new char[1000_007];
        int ans=-1;

        while(ei<cards.length){
            int x=cards[ei];
            ch[x]++;

            if(ch[x] == 2){
                while(ch[x]>1){
                    int y=cards[si];
                    ch[y]--;
                    si++;
                }
                flag=true;
                s=Math.min(s,ei-si+2);
              
            }
            ei++;
            
        }
        if(flag){
            return s;
        }
        return -1;
    }
}