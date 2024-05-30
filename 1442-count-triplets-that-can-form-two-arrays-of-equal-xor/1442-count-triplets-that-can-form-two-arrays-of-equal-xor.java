class Solution {
      public int countTriplets(int[] arr) {
             int n = arr.length;
            int count = 0;
        
        // Iterate over all possible starting points i
        for (int i = 0; i < n; i++) {
            int xor = 0;
            // Iterate over all possible end points k
            for (int k = i; k < n; k++) {
                xor ^= arr[k];
                // If xor is 0, then all elements from i to k form two equal subarrays
                if (xor == 0 && k > i) {
                    count += (k - i);
                }
            }
        }
        
        return count;
      }
}