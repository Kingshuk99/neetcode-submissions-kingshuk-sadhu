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

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);

        if(pu==pv) {
            return false;
        }

        if(rank[pu] >= rank[pv]) {
            rank[pu]+=rank[pv];
            parent[pv] = pu;
        } else {
            rank[pv]+=rank[pu];
            parent[pu] = pv;
        }
        return true;
    }

    public int getRank(int node) {
        return rank[find(node)];
    }
}
class Solution {
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        DSU dsu = new DSU(ROWS*COLS);
        int maxArea = 0;

        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                if(grid[r][c] != 1) {
                    continue;
                }
                for(int[] dir:dirs) {
                    int nr = r+dir[0], nc = c+dir[1];
                    if(nr<0 || nr>=ROWS || nc<0 || nc>=COLS || grid[nr][nc]!=1) {
                        continue;
                    }
                    dsu.union(r*COLS+c, nr*COLS+nc);
                }
                maxArea = Math.max(maxArea, dsu.getRank(r*COLS+c));
            }
        }
        return maxArea;
    }
}
