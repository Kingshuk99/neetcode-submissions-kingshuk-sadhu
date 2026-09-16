class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0, fresh = 0;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if(grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                int[] cell = queue.poll();

                for(int[] dir : dirs) {
                    int row = cell[0] + dir[0], col = cell[1] + dir[1];
                    if(isValid(grid, row, col)) {
                        grid[row][col] = 2;
                        queue.offer(new int[]{row, col});
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

    private boolean isValid(int[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || 
        grid[row][col] != 1) {
            return false;
        }
        return true;
    }
}
