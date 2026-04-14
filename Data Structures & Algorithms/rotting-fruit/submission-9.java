class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int fresh = 0, time = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    fresh++;
                } else if(grid[i][j]==2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(fresh > 0 && !queue.isEmpty()) {
            time++;
            int len = queue.size();
            for(int i=0; i<len; i++) {
                int[] curr = queue.poll();
                for(int[] dir : dirs) {
                    int x = curr[0]+dir[0], y = curr[1]+dir[1];
                    if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || 
                    grid[x][y]!=1) {
                        continue;
                    }
                    fresh--;
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return fresh != 0 ? -1 : time;
    }
}
