class DSU {
    int[] parents;
    int[] ranks;

    DSU(int n) {
        this.parents = new int[n];
        this.ranks = new int[n];

        for(int i = 0; i < n; i++) {
            this.parents[i] = i;
            this.ranks[i] = 1;
        }
    }

    int find(int node) {
        if(node != parents[node]) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }

    boolean isConnected(int node1, int node2) {
        int parent1 = find(node1), parent2 = find(node2);

        return parent1 == parent2;
    }

    boolean union(int node1, int node2) {
        int parent1 = find(node1), parent2 = find(node2);

        if(parent1 == parent2) {
            return false;
        }

        if(ranks[parent1] >= ranks[parent2]) {
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        } else {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        }
        return true;
    }
}
class Solution {
    int ROWS, COLS;
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        DSU dsu = new DSU(ROWS * COLS + 1);

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(board[i][j] != 'O') {
                    continue;
                }

                if(i == 0 || j == 0 || i == ROWS - 1 || j == COLS - 1) {
                    dsu.union(ROWS * COLS, i * COLS + j);
                } else {
                    for(int[] dir : dirs) {
                        int r = i + dir[0], c = j + dir[1];
                        if(board[r][c] == 'O') {
                            dsu.union(i * COLS + j, r * COLS + c);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(!dsu.isConnected(ROWS * COLS, i * COLS + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
