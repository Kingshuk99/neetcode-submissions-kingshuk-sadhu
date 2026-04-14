class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0]-b[0]));
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        int DIRECTIONS = 4;
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        int ans = 0;
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int h = curr[0], x = curr[1], y = curr[2];
            if(grid[x][y]==-1) {
                continue;
            }
            ans = Math.max(ans, h);
            if(x==grid.length-1 && y==grid[0].length-1) {
                return ans;
            }
            grid[x][y] = -1;

            for(int i=0; i<DIRECTIONS; i++) {
                int r = x+dx[i], c = y+dy[i];
                if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || 
                grid[r][c]==-1) {
                    continue;
                }
                minHeap.offer(new int[]{grid[r][c], r, c});
            }
        }
        return ans;
    }
}
