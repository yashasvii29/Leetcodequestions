class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        // DFS from boundary rows
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')
                dfs(board,visited,i,0);

            if(board[i][n-1]=='O')
                dfs(board,visited,i,n-1);
        }

        // DFS from boundary columns
        for(int j=0;j<n;j++){
            if(board[0][j]=='O')
                dfs(board,visited,0,j);

            if(board[m-1][j]=='O')
                dfs(board,visited,m-1,j);
        }

        // Convert surrounded regions
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int r, int c){

        int m = board.length;
        int n = board[0].length;

        if(r<0 || c<0 || r>=m || c>=n || board[r][c]=='X' || visited[r][c])
            return;

        visited[r][c] = true;

        for(int[] d : dirs){
            dfs(board, visited, r+d[0], c+d[1]);
        }
    }
}