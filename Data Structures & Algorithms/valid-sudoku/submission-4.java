class Solution {
    public boolean isValidSudoku(char[][] board) {
        int SIDES = board.length;
        int[] rows = new int[SIDES];
        int[] cols = new int[SIDES];
        int[] cells = new int[SIDES];

        for(int row = 0; row < SIDES; row++) {
            for(int col = 0; col < SIDES; col++) {
                if(board[row][col] == '.') {
                    continue;
                }
                int cell = (row / 3) * 3 + col / 3;
                int num = board[row][col] - '0';
                if((rows[row] & (1 << num)) != 0 || 
                (cols[col] & (1 << num)) != 0 || (cells[cell] & (1 << num)) != 0) {
                    return false;
                }
                rows[row] |= (1 << num);
                cols[col] |= (1 << num);
                cells[cell] |= (1 << num);
            }
        }
        return true;
    }
}
