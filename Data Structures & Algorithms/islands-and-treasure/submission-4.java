class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0; i<len; i++) {
                int[] curr = queue.poll();
                for(int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    if(canBeUpdated(x, y, grid)) {
                        grid[x][y] = grid[curr[0]][curr[1]] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }

    private boolean canBeUpdated(int x, int y, int[][] grid) {
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==-1 ||
        grid[x][y] < Integer.MAX_VALUE) {
            return false;
        }
        return true;
    }
}
