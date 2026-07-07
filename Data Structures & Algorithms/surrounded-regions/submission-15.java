class Solution {
    private int ROWS, COLS;
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public void solve(char[][] board) {
        //BFS
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
        board[r][c] = 'C';

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            for(int[] dir : dirs) {
                int row = cell[0] + dir[0], col = cell[1] + dir[1];
                if(row < 0 || row >= ROWS || col < 0 || col >= COLS || 
                board[row][col] != 'O') {
                    continue;
                }
                board[row][col] = 'C';
                queue.offer(new int[]{row, col});
            }
        }
    }
}
