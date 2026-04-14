class Solution {
    // BFS
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                maxArea = Math.max(maxArea, bfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int r, int c) {
        if(grid[r][c] != 1) {
            return 0;
        }
        int area = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        grid[r][c] = 2;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int i = temp[0], j = temp[1];

            for(int[] dir : dirs) {
                int nr = i+dir[0], nc = j+dir[1];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc] == 1) {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                    area++;
                }
            }
        }
        return area;
    }
}
