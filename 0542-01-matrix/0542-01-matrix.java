class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] dist = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all 0s to queue, mark 1s as unvisited (MAX_VALUE)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE; // unvisited
                }
            }
        }

        // Step 2: BFS outward from all 0s
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            for (int[] d : dirs) {
                int x = r + d[0];
                int y = c + d[1];

                // If we found a shorter path to neighbor
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    if (dist[x][y] > dist[r][c] + 1) {
                        dist[x][y] = dist[r][c] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return dist;
    }
}