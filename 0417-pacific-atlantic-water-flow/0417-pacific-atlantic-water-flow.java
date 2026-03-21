class Solution {
   
         private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private int rows, cols;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] pacific  = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
          // Start DFS from Pacific borders (top row + left col)
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific,  i, 0);        // left column
            dfs(heights, atlantic, i, cols - 1); // right column
        }

        // Start DFS from Atlantic borders (bottom row + right col)
        for (int j = 0; j < cols; j++) {
            dfs(heights, pacific,  0, j);        // top row
            dfs(heights, atlantic, rows - 1, j); // bottom row
        }

        // Collect cells reachable by BOTH oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (pacific[r][c] && atlantic[r][c])
                    result.add(Arrays.asList(r, c));

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c) {
        visited[r][c] = true; // mark this cell reachable from ocean

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            // Move to neighbor only if:
            // 1. Inside bounds
            // 2. Not already visited
            // 3. Height >= current (reverse flow = going uphill)
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                    && !visited[nr][nc]
                    && heights[nr][nc] >= heights[r][c]) {
                dfs(heights, visited, nr, nc);
            }
    }
    }
}
    


// Given a grid of heights, water can flow to a neighbor (up, down , left and right )
// if neighbor height <= current height

// Pacific Ocean  touches TOP and LEFT borders
// Atlantic Ocean touches BOTTOM and RIGHT borders

// Find all cells from which water can reach BOTH oceans



// Given a grid of heights, water can flow to a neighbor
// if neighbor height <= current height

// Pacific Ocean  touches TOP and LEFT borders
// Atlantic Ocean touches BOTTOM and RIGHT borders

// Find all cells from which water can reach BOTH oceans