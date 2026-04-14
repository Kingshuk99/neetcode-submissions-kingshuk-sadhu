class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0]-b[0]));
        int ans = 0;
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int h = curr[0], r = curr[1], c = curr[2];

            if(vis[r][c]) {
                continue;
            }

            vis[r][c] = true;
            ans = Math.max(ans, h);
            if(r==grid.length-1 && c==grid[0].length-1) {
                return ans;
            }

            for(int[] dir : dirs) {
                int x = r + dir[0], y = c + dir[1];
                if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || 
                vis[x][y]) {
                    continue;
                }

                minHeap.offer(new int[]{grid[x][y], x, y});
            }
        }

        return -1;
    }
}
