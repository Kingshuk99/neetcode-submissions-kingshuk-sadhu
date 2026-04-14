class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int itr=0; itr<len; itr++) {
                int[] curr = queue.poll();
                int i = curr[0], j = curr[1];
                for(int k=0; k<4; k++) {
                    int x = i+dx[k], y = j+dy[k];
                    if(x<0 || y<0 || x>=m || y>=n || grid[x][y]==-1) {
                        continue;
                    }
                    if(grid[x][y] > grid[i][j] + 1) {
                        grid[x][y] = grid[i][j] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
