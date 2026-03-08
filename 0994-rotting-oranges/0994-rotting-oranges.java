class Solution {
    public int orangesRotting(int[][] grid) {
        // use bfs traversal because hume har node ke immediate neighbours ko rotten krna h means adjacent neighbours ko
        // if any single fresh orange is left in grid then we will return -1
        // we have to return the minimum no of minutes to convert all the fresh oranges to rottm oranges
        // grid m we can have multiple rotten oranges means 2 which is our source node from where we have to start to make all the adjacent fresh oranges to rotten (means we have to convert adjacent fresh oranges to rotten oranges 1 to 2) so in this que we will use Multi source BFS

       if (grid == null && grid.length == 0)
            return -1;

        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
            }
        }

        if (freshOranges == 0)
            return 0;

        int minutes = 0;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // up, down, left, right

        while (!q.isEmpty()) {
            int qsize = q.size();

            // level of bfs - look out for neighbours
            for (int i = 0; i < qsize; i++) {
                int[] curr = q.poll();

                for (int[] dir : directions) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    // check for bounds
                    if (x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshOranges--;
                        q.offer(new int[] { x, y });
                    }
                }
            }

            // count level of bfs
            minutes++;
        }

     // for the last level of unecessary bfs level
        return freshOranges == 0 ? minutes - 1 : -1;
    
    }
}