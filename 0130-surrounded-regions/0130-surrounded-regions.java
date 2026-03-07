class Solution {
    // time complexity and space complexity is n*n 

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

// logic and explanantion of code
// 'O' = open region

// 'X' = wall

// Your job is to convert some 'O' to 'X'.

// But only those O's that are completely surrounded by X.

// What is a Region?

// A region is a group of connected 'O'.

// Connection means:

// Up
// Down
// Left
// Right

// NOT diagonal.

// Example region:

// O O
//   O

// These three O's form one region.



// What is "Surrounded"?

// A region is surrounded if:

// None of its O's touch the border of the board

// If a region touches the edge of the board, it cannot be surrounded.

// Example

// Input

// X X X X
// X O O X
// X X O X
// X O X X

// Look at the middle region:

// X O O X
// X X O X

// This region is fully surrounded by X, so we convert it.

// But look at this O
// X O X X

// This O is on the edge of the board.

// So it cannot be surrounded.

// It stays O.

// Final Output
// X X X X
// X X X X
// X X X X
// X O X X

// Only the middle O region becomes X.

// Simple Way to Think

// Ask this question:

// Can this O reach the border?

// If YES → keep it O

// If NO → convert to X

// Visual Example
// Edge
// ↓
// X X X X
// X O O X
// X X O X
// X O X X
//       ↑
//      edge

// The bottom O touches the edge → safe

// The middle O's do not → captured

// Real-Life Analogy

// Imagine water in a container.

// X = walls
// O = water

// Water that is completely trapped by walls gets removed.

// Water touching the boundary leaks out, so it stays.

// What the Algorithm Does

// Find O connected to border

// Mark them safe

// Convert remaining O → X

// One-Line Understanding

// The problem is basically:

// Convert all O's to X
// except the O's connected to the border