class DSU {
    int[] parents;
    int[] sizes;

    DSU(int n) {
        this.parents = new int[n];
        this.sizes = new int[n];

        for(int i = 0; i < n; i++) {
            this.parents[i] = i;
            this.sizes[i] = 1;
        }
    }

    int find(int node) {
        if(parents[node] != node) {
            parents[node] = find(parents[node]);
        }

        return parents[node];
    }

    boolean union(int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);
        if(p1 == p2) {
            return false;
        }

        if(sizes[p1] >= sizes[p2]) {
            parents[p2] = p1;
            sizes[p1] += sizes[p2];
        } else {
            parents[p1] = p2;
            sizes[p2] += sizes[p1];
        }

        return true;
    }

    boolean isConnected(int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);
        return p1 == p2;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        DSU dsu = new DSU(N * N);
        List<int[]> positions = new ArrayList<>();
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                positions.add(new int[]{grid[r][c], r, c});
            }
        }

        positions.sort((a, b) -> (a[0] - b[0]));

        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for(int[] pos : positions) {
            int t = pos[0], r = pos[1], c = pos[2];
            for(int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || grid[nr][nc] > t) {
                    continue;
                }
                dsu.union(r * N + c, nr * N + nc);
            }
            if(dsu.isConnected(0, N * N - 1)) {
                return t;
            }
        }

        return -1;
    }
}
