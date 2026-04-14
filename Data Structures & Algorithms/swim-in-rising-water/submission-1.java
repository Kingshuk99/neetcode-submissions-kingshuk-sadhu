class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currLevel = curr[0], r = curr[1], c = curr[2];
            if(vis[r][c]) {
                continue;
            }

            vis[r][c] = true;
            if(r==grid.length-1 && c==grid[0].length-1) {
                return currLevel;
            }

            for(int i=0; i<4; i++) {
                int x = r+dx[i], y = c+dy[i];
                if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || 
                vis[x][y]) {
                    continue;
                }
                minHeap.offer(new int[]{Math.max(currLevel, grid[x][y]), x, y});
            }
        }
        return -1;
    }
}
