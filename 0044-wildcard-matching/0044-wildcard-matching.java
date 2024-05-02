import java.util.Arrays;

class Solution {
    public boolean isMatch(String s, String p) {
        int[][] memo = new int[s.length() + 1][p.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return Matching(s, p, 0, 0, memo);
    }

    public static boolean Matching(String s, String p, int i, int j, int[][] memo) {
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        if (j == p.length()) {
            memo[i][j] = (i == s.length()) ? 1 : 0;
            return memo[i][j] == 1;
        }

        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    memo[i][j] = 0;
                    return false;
                }
            }
            memo[i][j] = 1;
            return true;
        }

        boolean ans = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = Matching(s, p, i + 1, j + 1, memo);
        } else if (p.charAt(j) == '*') {
            boolean match = Matching(s, p, i, j + 1, memo);
            boolean dontMatch = Matching(s, p, i + 1, j, memo);
            ans = match || dontMatch;
        }
        
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
}
