class Solution {
    public int[][] updateMatrix(int[][] mat) {
         int rows = mat.length;    // total rows in matrix
        int cols = mat[0].length; // total cols in matrix

        int[][] dist = new int[rows][cols]; // result matrix to store distances
        Queue<int[]> queue = new LinkedList<>(); // BFS queue stores {row, col}

        // ─────────────────────────────────────────────
        // STEP 1: Initialize
        // - If cell is 0 → distance is 0, add to queue (BFS starting points)
        // - If cell is 1 → distance unknown, mark as MAX_VALUE (unvisited)
        // ─────────────────────────────────────────────
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;                  // already at a 0, distance = 0
                    queue.add(new int[]{i, j});     // start BFS from ALL 0s simultaneously
                } else {
                    dist[i][j] = Integer.MAX_VALUE;  // not yet visited, distance unknown
                }
            }
        }

        // ─────────────────────────────────────────────
        // STEP 2: Direction vectors for 4 neighbors
        // {0, 1}  → move right
        // {0, -1} → move left
        // {1, 0}  → move down
        // {-1, 0} → move up
        // ─────────────────────────────────────────────
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        // ─────────────────────────────────────────────
        // STEP 3: BFS - spread outward from all 0s
        // Each level of BFS = 1 step away from nearest 0
        // ─────────────────────────────────────────────
        while (!queue.isEmpty()) {

            int[] curr = queue.poll(); // pick the front cell
            int r = curr[0];           // current row
            int c = curr[1];           // current col

            // Check all 4 neighbors of current cell
            for (int[] d : dirs) {
                int x = r + d[0]; // neighbor row
                int y = c + d[1]; // neighbor col

                // Check 1: neighbor must be inside matrix bounds
                if (x >= 0 && x < rows && y >= 0 && y < cols) {

                    // Check 2: can we give this neighbor a shorter distance?
                    // current cell's distance + 1 step = neighbor's new distance
                    if (dist[x][y] > dist[r][c] + 1) {

                        dist[x][y] = dist[r][c] + 1; // update with shorter distance
                        queue.add(new int[]{x, y}); // push neighbor to process its neighbors next
                    }
                }
            }
        }

        // dist[i][j] now holds the shortest distance to nearest 0 for every cell
        return dist;
    }
}