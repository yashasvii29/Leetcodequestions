class Solution {
    public int[][] largestLocal(int[][] grid) {
           int n = grid.length;
        int[][] res = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int r = i;
                int c = j;
                int max = Integer.MIN_VALUE;
                for (int p = r; p < r + 3; p++) {
                    for (int k = c; k < c + 3; k++) {
                        max = Math.max(grid[p][k], max);
                    }
                }
                res[i][j] = max;
            }
        }
        return res;
    }
}