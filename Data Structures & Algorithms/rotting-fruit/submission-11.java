class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0, fresh = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                int[] curr = queue.poll();
                for(int[] dir : dirs) {
                    int r = curr[0] + dir[0], c = curr[1] + dir[1];
                    if(isValid(grid, r, c)) {
                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        fresh--;
                    }
                }
            }
            if(!queue.isEmpty()) {
                time++;
            }
        }
        return fresh == 0 ? time : -1;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
        || grid[r][c] != 1) {
            return false;
        }
        return true;
    }
}
