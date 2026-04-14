class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==0) {
                    q.add(new int[] {i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int row = pos[0], col = pos[1];

            for(int i=0; i<4; i++) {
                int r = row + dir[i][0], c = col + dir[i][1];
                if(r<0 || c<0 || r>=m || c>=n || grid[r][c]!=Integer.MAX_VALUE) {
                    continue;
                }
                grid[r][c] = grid[row][col] + 1;
                q.add(new int[] {r, c});
            }
        }
    }
}
