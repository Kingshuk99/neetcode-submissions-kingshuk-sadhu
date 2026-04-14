class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        int fresh = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==2) {
                    q.add(new int[] {i, j});
                }
                else if(grid[i][j]==1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        while(fresh>0 && !q.isEmpty()) {
            int len = q.size();

            for(int i=0; i<len; i++) {
                int[] pos = q.poll();
                int row = pos[0], col = pos[1];
                for(int j=0; j<4; j++) {
                    int r = row + dirs[j][0], c = col + dirs[j][1];
                    if(r<0 || c<0 || r>=m || c>=n || grid[r][c]!=1) {
                        continue;
                    }
                    fresh--;
                    grid[r][c] = 2;
                    q.add(new int[]{r, c});
                }
            }
            time++;
        }
        return fresh==0?time:-1;
    }
}
