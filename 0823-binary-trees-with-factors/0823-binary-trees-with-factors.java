class Solution {
   private static final int MOD = 1000000007;

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> s = new HashSet<>();
        // set ka use arraylist ke liye kiya hai
        for (int x : arr) s.add(x);

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) map.put(x, 1);
        
        for (int i : arr) {
            for (int j : arr) {
                if (j > Math.sqrt(i)){
                    break;
                } 
                if (i % j == 0 && s.contains(i / j)) {
                    // (i/j) y factor check krneke liye kr he hai
                    long temp = (long) map.get(j) * map.get(i / j);
                    map.put(i, (int) ((map.get(i) + (i / j == j ? temp : temp * 2)) % MOD));
                }
            }
        }
        
        int sum = 0;
        for (int val : map.values()) {
            sum = (sum + val) % MOD;
        }

     return sum;
  
    }
}