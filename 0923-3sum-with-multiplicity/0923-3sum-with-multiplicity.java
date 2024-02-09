class Solution {
    public int threeSumMulti(int[] arr, int target) {

         long[] map = new long[101];
        long ans = 0;
        for (int num : arr) {
            map[num]++;
        }
        for (int k = 100; k >= 0; k--)
            for (int j = k; j >= 0; j--) {
                int i = target  - k - j;
                if (i > j || i < 0) 
                    continue;
                long x = map[i], y = map[j], z = map[k], res = x * y * z;
                if (res == 0) 
                    continue;
                if (i == k) res = x * (x-1) * (x-2) / 6;
                else if(i == j) {
                    res = x * (x-1) / 2 * z;
                }
                
                else if(j == k){
                      res = x * y * (y-1) / 2;
                }
                ans += res;
            }
        return (int)(ans % 1000000007);
  }
}












        // his is a brute force whose c is O
        // int c=0;
        // for(int i=0;i<arr.length-2;i++){
        //     for(int j=i+1;j<arr.length-1;j++){
        //         for(int k=j+1;k<arr.length;k++){
        //             if(arr[i]+arr[j]+arr[k]==target){
        //                 c++;
        //             }
        //         }
        //     }
        // }
        // return c%1000000007;