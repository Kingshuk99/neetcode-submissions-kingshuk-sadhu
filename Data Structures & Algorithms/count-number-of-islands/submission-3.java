class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        // BFS
        int islands = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    bfs(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(int i, int j, char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = '2';
        q.add(new int[]{i, j});

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0], c = temp[1];
            for(int[] dir : dirs) {
                int x = r + dir[0], y = c + dir[1];
                if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!='1') {
                    continue;
                }
                grid[x][y] = '2';
                q.add(new int[]{x, y});
            }
        }
    }
}
