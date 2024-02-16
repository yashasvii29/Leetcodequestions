class Solution {
    public void solveSudoku(char[][] board) {
        SudokuSolver(board,0,0);
    }
    private boolean SudokuSolver(char[][] board, int row, int col) {
        if (col == 9) {
            row++;
            col=0; 
        }
        if (row == 9) {
            return true;
        }
        if (board[row][col] != '.') {
            return SudokuSolver(board, row, col + 1);
        }
        else{
            for(char val='1';val<='9';val++){
                if(isitpossible(board,row,col,val)==true){
                    board[row][col]=val;
                   
                   if(SudokuSolver(board,row,col+1)){
                       return true ;
                   }
                    board[row][col]='.';//undo
                }
            }
        }   
        return false;
    }
    public static boolean isitpossible(char board[][],int row,int col,char val){
        
        // row
        int c=0;
        while(c<9){
            if(board[row][c]==val){
                return false;
            }
            c++;
        }
        //col
        int r=0;
        while(r<9){
            if(board[r][col]==val){
                return false;
            }
            r++;
        }
        // 3*3 matrix
        r=row-row%3;
        c=col-col%3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(board[i][j]==val){
                    return false;
                }
            }
        }
        return true;
    }
}