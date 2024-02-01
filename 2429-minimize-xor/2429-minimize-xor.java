class Solution {
    public int minimizeXor(int num1, int num2) {
        return Min_Val(num1,num2);
    }
      public static int Min_Val(int a,int b){
        int c=CountSet(b);
        int x=0;
        for(int i=31;i>=0 && c>0;i--){
            if((a&(1<<i))!=0){
                x+=(1<<i);
                c--;
            }
        }
        for(int i=0;i<=31 && c>0;i++){
            if((a&(1<<i))==0){
                x+= (1<<i);
                c--;
            }
            
        }
        return x;
    }

    public static int CountSet(int b){
        int c=0;
        while(b>0){
            c++;
             b=(b&(b-1));
        }
        return c;
    }
}