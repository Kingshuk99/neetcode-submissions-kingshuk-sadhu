class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            grid[cell[0]][cell[1]] = '2';
            for(int[] dir : dirs) {
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];

                if(isValid(row, col, grid)) {
                    queue.offer(new int[]{row, col});
                }
            }
        }
    }

    private boolean isValid(int r, int c, char[][] grid) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
        || grid[r][c] != '1') {
            return false;
        }
        return true;
    }
}
