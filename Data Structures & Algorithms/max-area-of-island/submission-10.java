class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = 2;
        q.add(new int[]{r, c});
        int res = 1;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for (int[] dir : dirs) {
                int nr = row + dir[0], nc = col + dir[1];
                if (isValid(grid, nr, nc)) {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
        || grid[r][c] != 1) {
            return false;
        }
        return true;
    }
}
