class Solution {
   
         private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private int rows, cols;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] pacific  = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific,  i, 0);
            dfs(heights, atlantic, i, cols-1);
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights, pacific,  0, j);
            dfs(heights, atlantic, rows-1, j);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (pacific[r][c] && atlantic[r][c])
                    result.add(Arrays.asList(r, c));
        
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                    && !visited[nr][nc] && heights[nr][nc] >= heights[r][c])
                dfs(heights, visited, nr, nc);
        }
    }
    }
