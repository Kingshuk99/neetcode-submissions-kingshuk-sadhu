class Solution {
    private int ROWS, COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        capture(board);

        replace(board, 'O', 'X');
        replace(board, 'C', 'O');
    }

    private void capture(char[][]board) {
        for(int i=0; i<ROWS; i++) {
            if(board[i][0]=='O') {
                captureUtil(board, i, 0);
            }

            if(board[i][COLS-1]=='O') {
                captureUtil(board, i, COLS-1);
            }
        }

        for(int i=1; i<COLS-1; i++) {
            if(board[0][i]=='O') {
                captureUtil(board, 0, i);
            }

            if(board[ROWS-1][i]=='O') {
                captureUtil(board, ROWS-1, i);
            }
        }
    }

    private void captureUtil(char[][]board, int r, int c) {
        if(r<0 || c<0 || r>=ROWS || c>=COLS || board[r][c]!='O') {
            return;
        }
        board[r][c] = 'C';
        captureUtil(board, r-1, c);
        captureUtil(board, r, c-1);
        captureUtil(board, r+1, c);
        captureUtil(board, r, c+1);
    }

    private void replace(char[][]board, char initialVal, char finalVal) {
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                if(board[i][j]==initialVal) {
                    board[i][j] = finalVal;
                }
            }
        }
    }
}
