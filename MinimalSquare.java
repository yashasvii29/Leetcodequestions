import java.util.*;
public class MinimalSquare {
    public static void main(String[] args) {
        Scanner yashu=new Scanner(System.in);
        int t=yashu.nextInt();
        while(t-->0){
            int a=yashu.nextInt();
            int b=yashu.nextInt();
            System.out.println(Display(a,b));
            
        }
    }
    public static int Display(int a,int b){
        
            int side=Math.max(2*a,b);
            int side1=Math.max(2*b,a);
            int ans=Math.min(side,side1);
            return ans*ans;
            
        }
    }

