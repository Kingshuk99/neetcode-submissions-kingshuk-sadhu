class Solution {
    int ROWS, COLS;
    int PACIFIC = 0, ATLANTIC = 1;
    int[][] seas;
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    List<List<Integer>> cells;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //BFS
        ROWS = heights.length;
        COLS = heights[0].length;
        cells = new ArrayList<>();
        seas = new int[ROWS][COLS];

        for(int i = 0; i < ROWS; i++) {
            bfs(PACIFIC, heights, i, 0);
            bfs(ATLANTIC, heights, i, COLS - 1);
        }

        for(int i = 0; i < COLS; i++) {
            bfs(PACIFIC, heights, 0, i);
            bfs(ATLANTIC, heights, ROWS - 1, i);
        }

        for(int i = 0; i <ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(seas[i][j] == 3) {
                    cells.add(Arrays.asList(i, j));
                }
            }
        }

        return cells;
    }

    private void bfs(int sea, int[][] heights, int r, int c) {
        seas[r][c] |= (1 << sea);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];

            for(int[] dir : dirs) {
                int row = i + dir[0], col = j + dir[1];
                if(row < 0 || col < 0 || row >= ROWS || col >= COLS || 
                    (seas[row][col] & (1 << sea)) == (1 << sea) || 
                    heights[row][col] < heights[i][j]) {
                    continue;
                }
                seas[row][col] |= (1 << sea);
                queue.offer(new int[]{row, col});
            }
        }
    }
}
