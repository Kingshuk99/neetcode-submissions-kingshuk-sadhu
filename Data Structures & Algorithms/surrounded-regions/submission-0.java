class Solution {
    private int m, n;
    private void capture(char[][] board, int i, int j) {
        if(i<0 || j<0 || i==m || j==n || board[i][j]!='O') {
            return;
        }
        board[i][j] = 'C';
        capture(board, i+1, j);
        capture(board, i-1, j);
        capture(board, i, j+1);
        capture(board, i, j-1);
    }
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]=='O' && (i==0 || j==0 || i==m-1 || j==n-1)) {
                    capture(board, i, j);
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]=='O') {
                    board[i][j] = 'X';
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]=='C') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
