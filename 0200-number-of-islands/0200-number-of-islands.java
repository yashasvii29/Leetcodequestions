class Solution {
    // time complexity and space complexity is m*n 
    // logic of code 
//     We traverse the entire grid.

// Whenever we find a land cell ('1') that is not visited, it means we discovered a new island and will icrease the count of island.

// Then we perform DFS to visit all connected land cells means neighbour of that vertex or node of that island and mark them visited so they are not counted again.
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
// Count number of connected components in a graph means count number of islands in a graph
// Treat grid as a graph.

// Iterate through all vertices.

// If vertex = '1' and not visited
// → start DFS traversal.

// DFS explores the entire connected component.

// Increase island count.