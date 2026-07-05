class Solution {
    int PACIFIC = 0, ATLANTIC = 1, ROWS, COLS;
    int[][] seas;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        seas = new int[ROWS][COLS];

        for(int i = 0; i < ROWS; i++) {
            dfs(heights, i, 0, PACIFIC, heights[i][0]);
            dfs(heights, i, COLS - 1, ATLANTIC, heights[i][COLS - 1]);
        }

        for(int i = 0; i < COLS; i++) {
            dfs(heights, 0, i, PACIFIC, heights[0][i]);
            dfs(heights, ROWS - 1, i, ATLANTIC, heights[ROWS - 1][i]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(seas[i][j] == 3) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, int row, int col, int sea, 
    int prev) {
        if(row < 0 || col < 0 || row >= ROWS || col >= COLS ||
        heights[row][col] < prev || 
        (seas[row][col] & (1 << sea)) == (1 << sea)) {
            return;
        }

        seas[row][col] |= (1 << sea);
        for(int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            dfs(heights, newRow, newCol, sea, heights[row][col]);
        }
    }
}
