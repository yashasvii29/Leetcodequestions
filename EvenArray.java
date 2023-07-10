import java.util.*;
public class EvenArray {
    public static void main(String[] args) {
        Scanner yashu=new Scanner(System.in);
        int t=yashu.nextInt();
        while(t-->0){
            int n=yashu.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=yashu.nextInt();
            }
            System.out.println(Display(arr,n));
            
        }
    }
    public static int Display(int arr[],int n){
        int c1=0,c2=0;
        if(n==1){
            if(arr[0]%2!=0)
                return -1;
            else
                return 0;
        }
        int len=1, ele=arr[0];
       for(int i=1;i<n;i++){
        
        if(arr[i]==ele)
                len++;
       }
       if(len==n)
        return -1;
        for(int i=0;i<n;i++){
            if(i%2==0){
                if(arr[i]%2!=0){
                    c1++;
                }
            }
            else{
                if(arr[i]%2==0){
                    c2++;
                }
            }
        }
        // swap krne ke liye counter same hona chahiye 
        if(c1==0 && c2==0)
            return 0;
        if(c1!=c2)
            return -1;
        else
            return c1;
       
        
        }
}
