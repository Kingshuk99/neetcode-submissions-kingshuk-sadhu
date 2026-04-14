class DSU {
    private int[] parent, rank;
    public DSU(int n) {
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=0; i<=n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        if(node != parent[node]) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if(pa == pb) {
            return false;
        }

        if(rank[pa] >= rank[pb]) {
            rank[pa]++;
            parent[pb] = pa;
        } else {
            rank[pb]++;
            parent[pa] = pb;
        }
        return true;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        // DSU
        int islands = 0;
        int ROWS = grid.length, COLS = grid[0].length;
        DSU dsu = new DSU(ROWS*COLS);
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    for(int[] dir : dirs) {
                        int r = i+dir[0], c = j+dir[1];
                        if(r<0 || c<0 || r>=ROWS || c>=COLS || grid[r][c] != '1') {
                            continue;
                        }
                        if(dsu.union(i*COLS+j, r*COLS+c)) {
                            islands--;
                        }
                    }
                }
            }
        }
        return islands;
    }
}
