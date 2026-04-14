class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0]-b[0]));
        int ans = 0;
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int height = curr[0], i = curr[1], j = curr[2];
            if(grid[i][j]==-1) {
                continue;
            }
            ans = Math.max(ans, height);
            if(i==grid.length-1 && j==grid[0].length-1) {
                return ans;
            }
            grid[i][j] = -1;
            for(int[] dir : dirs) {
                int x = i+dir[0], y = j+dir[1];
                if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || 
                grid[x][y]==-1) {
                    continue;
                }
                minHeap.offer(new int[]{grid[x][y], x, y});
            }
        }
        return ans;
    }
}
