class Solution {
    int[] dy = new int[]{-1, 0, 1, 0};
    int[] dx = new int[]{0, -1, 0, 1};

    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int m = grid.length, n = grid[0].length;
        minHeap.offer(new int[]{grid[0][0], 0, 0});

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            int level = curr[0], x = curr[1], y = curr[2];
            if(vis[x][y]) {
                continue;
            }

            vis[x][y] = true;

            if(x==m-1 && y ==n-1) {
                return level;
            }

            for(int i=0; i<4; i++) {
                int nextX = x+dx[i], nextY = y+dy[i];
                if(nextX<0 || nextX>=m || nextY<0 || nextY>=n || vis[nextX][nextY]) {
                    continue;
                }
                int nextLevel = Math.max(level, grid[nextX][nextY]);
                minHeap.offer(new int[]{nextLevel, nextX, nextY});
            }
        }

        return -1;
    }
}
