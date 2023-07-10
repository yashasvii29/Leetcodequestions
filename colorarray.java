import java.util.*;
public class colorarray {
       public static void main(String[] args){
        Scanner yashu=new Scanner(System.in);
        int t=yashu.nextInt();
        while(t-->0){
            int n=yashu.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=yashu.nextInt();
            }
             System.out.println(Display(n,arr));
        }
        
    }
    public static int Display(int n,int arr[]){
        int ans=0;
        if(n==1)
            return ans;
        int ele=arr[0];
        int c=1;
        for(int i=1;i<n;i++){
            if(arr[i]==ele){
                c++;
                if(c==n)
                    return ans;
            }
                
        }
        Arrays.sort(arr);
        int sum=0;
        int i=0;
            while(i<n){
                sum=sum+(arr[n-1]-arr[i]);
                i++;
                n--;
            }
            ans=sum;
        

        return ans;
    } 
}

