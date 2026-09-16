class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] dir : dirs) {
                int r = curr[0] + dir[0], c = curr[1] + dir[1];
                if(cannotTraverse(grid, r, c)) {
                    continue;
                }
                grid[r][c] = grid[curr[0]][curr[1]] + 1;
                queue.offer(new int[]{r, c});
            }
        }
    }

    private boolean cannotTraverse(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || 
        grid[r][c] == -1 || grid[r][c] != Integer.MAX_VALUE) {
            return true;
        }
        return false;
    }
}
