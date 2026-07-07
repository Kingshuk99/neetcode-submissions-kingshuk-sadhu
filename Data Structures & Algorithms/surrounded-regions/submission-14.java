class Solution {
    private int ROWS, COLS;
    public void solve(char[][] board) {
        //DFS
        ROWS = board.length;
        COLS = board[0].length;
        for(int i = 0; i < ROWS; i++) {
            if(board[i][0] == 'O') {
                capture(board, i, 0);
            }
            if(board[i][COLS - 1] == 'O') {
                capture(board, i, COLS - 1);
            } 
        }

        for(int i = 0; i < COLS; i++) {
            if(board[0][i] == 'O') {
                capture(board, 0, i);
            }
            if(board[ROWS - 1][i] == 'O') {
                capture(board, ROWS - 1, i);
            } 
        }

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(board[i][j] == 'C') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void capture(char[][] board, int r, int c) {
        if(r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'C';
        capture(board, r + 1, c);
        capture(board, r, c + 1);
        capture(board, r - 1, c);
        capture(board, r, c - 1);
    }
}
