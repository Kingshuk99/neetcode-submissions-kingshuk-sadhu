class Solution {
    // SOl 1
    // public void solve(char[][] board) {
    //     int ROWS = board.length, COLS = board[0].length;
    //     protect(board, ROWS, COLS);
    //     replace(board, ROWS, COLS, 'O', 'X');
    //     replace(board, ROWS, COLS, 'C', 'O');
    // }

    // private void replace(char[][] board, int ROWS, int COLS, char initialChar, 
    // char finalChar) {
    //     for(int i=0; i<ROWS; i++) {
    //         for(int j=0; j<COLS; j++) {
    //             if(board[i][j]==initialChar) {
    //                 board[i][j] = finalChar;
    //             }
    //         }
    //     }
    // }
    // private void protect(char[][] board, int ROWS, int COLS) {
    //     for(int i=0; i<ROWS; i++) {
    //         if(board[i][0]=='O') {
    //             dfs(board, i, 0, ROWS, COLS);
    //         }
    //         if(board[i][COLS-1]=='O') {
    //             dfs(board, i, COLS-1, ROWS, COLS);
    //         }
    //     }

    //     for(int i=0; i<COLS; i++) {
    //         if(board[0][i]=='O') {
    //             dfs(board, 0, i, ROWS, COLS);
    //         }
    //         if(board[ROWS-1][i]=='O') {
    //             dfs(board, ROWS-1, i, ROWS, COLS);
    //         }
    //     }
    // }
    
    // private void dfs(char[][] board, int row, int col, int ROWS, int COLS) {
    //     if(row < 0 || col < 0 || row >= ROWS || col >= COLS || 
    //     board[row][col] != 'O') {
    //         return;
    //     }
    //     board[row][col] = 'C';
    //     dfs(board, row+1, col, ROWS, COLS);
    //     dfs(board, row-1, col, ROWS, COLS);
    //     dfs(board, row, col+1, ROWS, COLS);
    //     dfs(board, row, col-1, ROWS, COLS);
    // }

    // Sol 2
    class DSU {
        int[] parents;
        int[] ranks;

        DSU(int n) {
            this.parents = new int[n+1];
            this.ranks = new int[n+1];

            for(int i=0; i<=n; i++) {
                this.parents[i] = i;
                this.ranks[i] = 1;
            }
        }

        int find(int node) {
            while(parents[node]!=node) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }

            return node;
        }

        void union(int u, int v) {
            int pu = find(u), pv = find(v);

            if(pu == pv) {
                return;
            }

            if(ranks[pu] >= ranks[pv]) {
                parents[pv] = pu;
                ranks[pu]++;
            } else {
                parents[pu] = pv;
                ranks[pv]++;
            }
        }

        boolean isConnected(int u, int v) {
            return find(u) == find(v);
        }
    }
    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        DSU dsu = new DSU(ROWS*COLS);

        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                if(board[i][j] != 'O') {
                    continue;
                }
                if(i==0 || j==0 || i==ROWS-1 || j==COLS-1) {
                    dsu.union(ROWS*COLS, i*COLS+j);
                } else {
                    for(int[] dir : dirs) {
                        int x = i+dir[0], y = j+dir[1];
                        if(board[x][y] == 'O') {
                            dsu.union(i*COLS+j, x*COLS+y);
                        }
                    }
                }
            }
        }

        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                if(!dsu.isConnected(ROWS*COLS, i*COLS+j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
