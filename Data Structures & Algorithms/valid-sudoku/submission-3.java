class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];

        for(int r=0; r<board.length; r++) {
            for(int c=0; c<board[0].length; c++) {
                if(board[r][c] == '.') {
                    continue;
                }

                int val = board[r][c] - '0';
                int square = 3*(r/3) + c/3;
                int currElement = 1 << val;
                if((rows[r] & currElement) > 0 || (cols[c] & currElement) > 0 ||
                (squares[square] & currElement) > 0) {
                    return false;
                }
                rows[r] |= currElement;
                cols[c] |= currElement;
                squares[square] |= currElement;
            }
        }
        return true;
    }
}
