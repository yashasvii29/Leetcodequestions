class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int islands = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]=='1' && !visited[i][j]){
                    islands++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int r, int c){

        int m = grid.length;
        int n = grid[0].length;

        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]=='0' || visited[r][c])
            return;

        visited[r][c] = true;

        for(int[] d : dirs){
            dfs(grid, visited, r+d[0], c+d[1]);
        }
    }
}