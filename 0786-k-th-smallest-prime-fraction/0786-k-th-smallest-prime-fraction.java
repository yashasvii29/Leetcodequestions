// class Solution {
//     public int[] kthSmallestPrimeFraction(int[] arr, int k) {
//         int ans[]=new int[2];
//         PriorityQueue<Double> pq =new PriorityQueue<>();
//         // min heap  
//         for(int i=0;i<arr.length;i++){
//             for(int j=i+1;j<arr.length;j++){
//                 double key=(double)arr[i]/(double)arr[j];
//                 pq.add(key);

//             }
//         }
//         double ele=0.0;
    
//         while(k-->0){
//             ele=pq.poll();
//         }
        
//          for(int i=0;i<arr.length;i++){
//             for(int j=i+1;j<arr.length;j++){
//                 if(ele==((double)arr[i]/(double)arr[j]));
//                 ans[0]=arr[i];
//                 ans[1]=arr[j];
//                 break;

//             }
//         }
//         return ans;
        
//     }
// }



import java.util.PriorityQueue;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[] ans = new int[2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Double.compare((double) arr[a[0]] / arr[a[1]], (double) arr[b[0]] / arr[b[1]]));
        
        for (int i = 0; i < arr.length - 1; i++) {
            pq.offer(new int[]{i, arr.length - 1}); // initially add all fractions with 1 as numerator
        }
        
        while (k-- > 0) {
            int[] top = pq.poll();
            ans[0] = arr[top[0]];
            ans[1] = arr[top[1]];
            if (top[1] > top[0] + 1) {
                pq.offer(new int[]{top[0], top[1] - 1});
            }
        }
        
        return ans;
    }
}
