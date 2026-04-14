class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];

        for(int r=0; r<9; r++) {
            for(int c=0; c<9; c++) {
                if(board[r][c] == '.') {
                    continue;
                }

                int val = board[r][c] - '0';
                int square = (r/3)*3 + c/3;
                if((rows[r] & (1 << val)) > 0 || 
                (cols[c] & (1 << val)) > 0 || 
                (squares[square] & (1 << val)) > 0) {
                    return false;
                }

                rows[r] |= (1 << val);
                cols[c] |= (1 << val);
                squares[square] |= (1 << val);
            }
        }

        return true;
    }
}
