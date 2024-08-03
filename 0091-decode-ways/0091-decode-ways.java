class Solution {
    static String arr[] = {"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    static int c = 0;
    static HashMap<String,Integer> map=new HashMap<>();

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        c = 0; // Reset the counter before starting a new test case..that's why again fun ke andar c ko 0 initialise kr rhe hai
         map=new HashMap<>(); // reset the map again before starting a new test case.
        PrintStrings(s, "");
        return c;

    }
   
    public static void PrintStrings(String que, String ans) {
        if (que.length() == 0) {
            // System.out.println(ans);
            c++;
            return;
        }

         // Check memoization map
        if (map.containsKey(que)) {
            c += map.get(que);
            return;
        }
        int initialCount = c;

        char ch = que.charAt(0);
        if (ch == '0') return; // Ensure that a standalone '0' does not proceed.

        String s = arr[ch - 48];
        PrintStrings(que.substring(1), ans + s);
        if (que.length() >= 2) {
            String s2 = que.substring(0, 2);
            int n = Integer.parseInt(s2);
            if (n <= 26) {
                PrintStrings(que.substring(2), ans + arr[n]);
            }
        }
          map.put(que, c - initialCount);
    }
}
