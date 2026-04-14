class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        protect(board, ROWS, COLS);
        replace(board, ROWS, COLS, 'O', 'X');
        replace(board, ROWS, COLS, 'C', 'O');
    }

    private void replace(char[][] board, int ROWS, int COLS, char initialChar, 
    char finalChar) {
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                if(board[i][j]==initialChar) {
                    board[i][j] = finalChar;
                }
            }
        }
    }
    private void protect(char[][] board, int ROWS, int COLS) {
        for(int i=0; i<ROWS; i++) {
            if(board[i][0]=='O') {
                dfs(board, i, 0, ROWS, COLS);
            }
            if(board[i][COLS-1]=='O') {
                dfs(board, i, COLS-1, ROWS, COLS);
            }
        }

        for(int i=0; i<COLS; i++) {
            if(board[0][i]=='O') {
                dfs(board, 0, i, ROWS, COLS);
            }
            if(board[ROWS-1][i]=='O') {
                dfs(board, ROWS-1, i, ROWS, COLS);
            }
        }
    }
    
    private void dfs(char[][] board, int row, int col, int ROWS, int COLS) {
        if(row < 0 || col < 0 || row >= ROWS || col >= COLS || 
        board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'C';
        dfs(board, row+1, col, ROWS, COLS);
        dfs(board, row-1, col, ROWS, COLS);
        dfs(board, row, col+1, ROWS, COLS);
        dfs(board, row, col-1, ROWS, COLS);
    }
}
