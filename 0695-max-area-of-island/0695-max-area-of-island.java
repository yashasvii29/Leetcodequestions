class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int maxArea = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j] == 1 && !visited[i][j]){

                    int area = dfs(grid, visited, i, j);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int r, int c){

        int m = grid.length;
        int n = grid[0].length;

        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]==0 || visited[r][c])
            return 0;

        visited[r][c] = true;

        int area = 1;

        for(int[] d : dirs){
            area += dfs(grid, visited, r+d[0], c+d[1]);
        }

        return area;
    }
}