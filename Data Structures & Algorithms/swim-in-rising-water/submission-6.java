class Solution {
    class DSU {
        int[] parents;
        int[] ranks;
        public DSU(int n) {
            this.parents = new int[n];
            this.ranks = new int[n];
            for(int i=0; i<n; i++) {
                this.parents[i] = i;
                this.ranks[i] = 1;
            }
        }

        private int find(int node) {
            while(parents[node] != node) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }

        public void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if(pa == pb) {
                return;
            }

            if(ranks[pa]>=ranks[pb]) {
                parents[pb] = pa;
                ranks[pa]++;
            } else {
                parents[pa] = pb;
                ranks[pb]++;
            }
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }
    }
    public int swimInWater(int[][] grid) {
        // Djikstra's Algorithm
        // PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0]-b[0]));
        // int ans = 0;
        // minHeap.offer(new int[]{grid[0][0], 0, 0});
        // boolean[][] vis = new boolean[grid.length][grid[0].length];
        // int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        // while(!minHeap.isEmpty()) {
        //     int[] curr = minHeap.poll();
        //     int h = curr[0], r = curr[1], c = curr[2];

        //     if(vis[r][c]) {
        //         continue;
        //     }

        //     vis[r][c] = true;
        //     ans = Math.max(ans, h);
        //     if(r==grid.length-1 && c==grid[0].length-1) {
        //         return ans;
        //     }

        //     for(int[] dir : dirs) {
        //         int x = r + dir[0], y = c + dir[1];
        //         if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || 
        //         vis[x][y]) {
        //             continue;
        //         }

        //         minHeap.offer(new int[]{grid[x][y], x, y});
        //     }
        // }

        // return -1;

        // Kruskal's Algorithm
        int ROWS = grid.length, COLS = grid[0].length;
        DSU dsu = new DSU(ROWS*COLS);
        List<int[]> positions = new ArrayList<>();
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                positions.add(new int[]{grid[i][j], i, j});
            }
        }

        Collections.sort(positions, (a, b) -> (a[0] - b[0]));
        int[][] dirs = {
            {-1, 0}, {0, -1}, {1, 0}, {0, 1}
        };

        for(int[] position : positions) {
            int t = position[0], r = position[1], c = position[2];
            for(int[] dir : dirs) {
                int x = r + dir[0], y = c + dir[1];
                if(x<0 || x>=ROWS || y<0 || y>=COLS || grid[x][y]>t) {
                    continue;
                }
                dsu.union(r*COLS+c, x*COLS+y);
            }
            if(dsu.isConnected(0*COLS+0, (ROWS-1)*COLS+COLS-1)) {
                return t;
            }
        }
        return -1;
    }
}
