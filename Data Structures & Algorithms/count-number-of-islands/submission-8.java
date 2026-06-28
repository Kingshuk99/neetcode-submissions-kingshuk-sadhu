class Solution {
    int ROWS, COLS;
    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        DSU dsu = new DSU(ROWS * COLS);
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int islands = 0;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] != '1') {
                    continue;
                }

                islands++;
                for(int[] dir : dirs) {
                    int row = r + dir[0], col = c + dir[1];
                    if(!isLand(grid, row, col)) {
                        continue;
                    }
                    if(dsu.union(row * COLS + col, r * COLS + c)) {
                        islands--;
                    }
                }
            }
        }

        return islands;
    }

    private boolean isLand(char[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= ROWS || col >= COLS || 
        grid[row][col] != '1') {
            return false;
        }
        return true;
    }
}

class DSU {
    int[] parents;
    int[] ranks;

    public DSU(int n) {
        this.parents = new int[n + 1];
        this.ranks = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            this.parents[i] = i;
            this.ranks[i] = 1;
        }
    }

    private int find(int node) {
        if(node != parents[node]) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }

    public boolean union(int a, int b) {
        int pa = find(a), pb = find(b);

        if(pa == pb) {
            return false;
        }

        if(ranks[pa] >= ranks[pb]) {
            parents[pb] = pa;
            ranks[pa] += ranks[pb];
        } else {
            parents[pa] = pb;
            ranks[pb] += ranks[pa];
        }
        return true;
    }
}
