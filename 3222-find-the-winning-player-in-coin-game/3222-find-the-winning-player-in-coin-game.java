class Solution {
    public String losingPlayer(int x, int y) {
          boolean flag=false;
        while(x>0 && y>=4) {
            x--;
            y-=4;
            flag=!flag;
        }
        return flag ? "Alice":"Bob";
        
    }

}