class DSU {
    int[] parents;
    int[] ranks;
    public DSU(int n) {
        this.parents = new int[n + 1];
        this.ranks = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                this.parents[i] = i;
                this.ranks[i] = 1;
            }
        }
    }

    public int find(int node) {
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

        if(pa >= pb) {
            parents[pb] = pa;
            ranks[pa]++;
        } else {
            parents[pa] = pb;
            ranks[pb]++;
        }

        return true;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        DSU dsu = new DSU(ROWS * COLS);
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int islands = 0;
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(grid[i][j] != '1') {
                    continue;
                }
                islands++;
                for(int[] dir : dirs) {
                    int r = i + dir[0], c = j + dir[1];
                    if(!isValid(grid, r, c)) {
                        continue;
                    }
                    if(dsu.union(i * COLS + j, r * COLS + c)) {
                        islands--;
                    }
                }
            }
        }

        return islands;
    }

    private boolean isValid(char[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || 
        grid[r][c] != '1') {
            return false;
        }
        return true;
    }
}
