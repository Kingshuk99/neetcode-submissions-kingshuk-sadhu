class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, -1, 0, 1};
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];
            for(int k=0; k<4; k++) {
                int x = i+dx[k], y = j+dy[k];
                if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || 
                grid[x][y]==-1) {
                    continue;
                }
                if(grid[x][y] > grid[i][j] + 1) {
                    grid[x][y] = grid[i][j] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
}
