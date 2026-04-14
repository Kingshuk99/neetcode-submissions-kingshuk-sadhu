class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[] dy = {0, -1, 0, 1};
        int[] dx = {-1, 0, 1, 0};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for(int k=0; k<4; k++) {
                int i = x+dx[k], j = y+dy[k];
                if(!isValid(grid, i, j)) {
                    continue;
                }
                grid[i][j] = grid[x][y]+1;
                q.offer(new int[]{i, j});
            }
        }
    }

    private boolean isValid(int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=Integer.MAX_VALUE) {
            return false;
        }
        return true;
    }
}
