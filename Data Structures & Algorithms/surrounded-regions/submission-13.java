class DSU {
    int[] parents, ranks;
    public DSU(int n) {
        this.parents = new int[n];
        this.ranks = new int[n];

        for(int i = 0; i < n; i++) {
            this.parents[i] = i;
            this.ranks[i] = 1;
        }
    }

    public int find(int node) {
        if(node != parents[node]) {
            parents[node] = find(parents[node]);
        }

        return parents[node];
    }

    public boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }

    public boolean union(int node1, int node2) {
        int parent1 = find(node1), parent2 = find(node2);

        if(parent1 == parent2) {
            return false;
        }

        if(ranks[parent1] >= ranks[parent2]) {
            parents[parent2] = parent1;
            ranks[parent1]++;
        } else {
            parents[parent1] = parent2;
            ranks[parent2]++;
        }
        return true;
    }
}
class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        DSU dsu = new DSU(ROWS * COLS + 1);
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(board[r][c] != 'O') {
                    continue;
                }

                if(r == 0 || c == 0 || r == ROWS - 1 || 
                c == COLS - 1) {
                    dsu.union(ROWS * COLS, r * COLS + c);
                    continue;
                } 

                for(int[] dir : dirs) {
                    int row = r + dir[0], col = c + dir[1];
                    if(board[row][col] != 'O') {
                        continue;
                    }
                    dsu.union(r * COLS + c, row * COLS + col);
                }
            }
        }

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c <COLS; c++) {
                if(board[r][c] == 'O' && 
                !dsu.isConnected(ROWS * COLS, r * COLS + c)) {
                    board[r][c] = 'X';
                }
            }
        }
    }
}
