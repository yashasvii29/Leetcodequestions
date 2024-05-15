class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] distToThief = getDistToThief(grid);
        int l = 0;
        int r = grid.size() * 2;

        while (l < r) {
            final int m = (l + r) / 2;
            if (hasValidPath(distToThief, m))
                l = m + 1;
            else
                r = m;
        }

        return l - 1;
    }

    private boolean hasValidPath(int[][] distToThief, int safeness) {
        int n = distToThief.length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] seen = new boolean[n][n];
        q.offer(new int[]{0, 0});
        seen[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];
            
            if (distToThief[i][j] < safeness)
                continue;

            if (i == n - 1 && j == n - 1)
                return true;

            for (int k = 0; k < 4; ++k) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                
                if (x >= 0 && x < n && y >= 0 && y < n && !seen[x][y]) {
                    q.offer(new int[]{x, y});
                    seen[x][y] = true;
                }
            }
        }

        return false;
    }

    private static final int[] dirs = {0, 1, 0, -1, 0};

    private int[][] getDistToThief(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] distToThief = new int[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] seen = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        for (int dist = 0; !q.isEmpty(); ++dist) {
            for (int sz = q.size(); sz > 0; --sz) {
                int[] curr = q.poll();
                int i = curr[0], j = curr[1];
                distToThief[i][j] = dist;

                for (int k = 0; k < 4; ++k) {
                    int x = i + dirs[k];
                    int y = j + dirs[k + 1];

                    if (x >= 0 && x < n && y >= 0 && y < n && !seen[x][y]) {
                        q.offer(new int[]{x, y});
                        seen[x][y] = true;
                    }
                }
            }
        }
        return distToThief;
    }
}