class Solution {
   public int integerReplacement(int n) {
        return replace(n);
    }

    private int replace(long n) {
        if (n == 1) {
            return 0;
        }
        
        if (n % 2 == 0) {
            return 1 + replace(n / 2);  // If n is even, divide by 2
        } else {
            // If n is odd, consider both adding 1 and subtracting 1
            return 1 + Math.min(replace(n + 1), replace(n - 1));
        }
    }
}