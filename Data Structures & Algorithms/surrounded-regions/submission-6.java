class Solution {
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
