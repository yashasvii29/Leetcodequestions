public class towerofh {
    public static void main(String[] args) {
        int n=3;
        toh(n,"A","B","C");//A...source,B....helper,C....Destination
    }
    public static void toh(int n,String src,String hlp,String des) {
        if(n==0)
            return;
        toh(n-1,src,des,hlp);  // starting ki (n-1)disc ko src se hel pr lekar jayenge
        System.out.println("Move "+n+"th"+" disc from "+src+" "+des);  
        toh(n-1,hlp,src,des);      
    }
}
  