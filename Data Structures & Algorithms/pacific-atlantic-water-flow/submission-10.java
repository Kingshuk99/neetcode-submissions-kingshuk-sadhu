class Solution {
    int ROWS, COLS;
    int PACIFIC = 0, ATLANTIC = 1;
    int[][] seas;
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    List<List<Integer>> cells;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //DFS
        ROWS = heights.length;
        COLS = heights[0].length;
        cells = new ArrayList<>();
        seas = new int[ROWS][COLS];

        for(int i = 0; i < ROWS; i++) {
            dfs(PACIFIC, heights, i, 0, heights[i][0]);
            dfs(ATLANTIC, heights, i, COLS - 1, heights[i][COLS - 1]);
        }

        for(int i = 0; i < COLS; i++) {
            dfs(PACIFIC, heights, 0, i, heights[0][i]);
            dfs(ATLANTIC, heights, ROWS - 1, i, heights[ROWS - 1][i]);
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

    private void dfs(int sea, int[][] heights, int r, int c, int prev) {
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || 
        (seas[r][c] & (1 << sea)) == (1 << sea) || heights[r][c] < prev) {
            return;
        }

        seas[r][c] |= (1 << sea);

        for(int[] dir : dirs) {
            int row = r + dir[0], col = c + dir[1];
            dfs(sea, heights, row, col, heights[r][c]);
        }
    }
}
