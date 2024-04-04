import java.util.*;
public class SplitArray {
    public static void main(String[] args) {
        Scanner yashu=new Scanner(System.in);
        int n=yashu.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=yashu.nextInt();
        }
        Printsubset1(arr,0,"",0,"",0);
    }
    public static void Printsubset1(int arr[], int i,String ans1,int sum1,String ans2,int sum2){
        
        if(i==arr.length){
            if(sum1==sum2){
                System.out.println(ans1+"and "+ans2);
            }
            return;
        }

        Printsubset1(arr, i+1, ans1,sum1,ans2+arr[i]+" ",sum2+arr[i]); // no element added
        Printsubset1(arr, i+1, ans1+arr[i]+" ",sum1+arr[i],ans2,sum2); // element added
    }
    
}
