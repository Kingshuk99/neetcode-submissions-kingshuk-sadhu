class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 0) {
                    continue;
                }
                ans += 4;
                if(r > 0 && grid[r - 1][c] == 1) {
                    ans -= 2;
                }
                if(c > 0 && grid[r][c - 1] == 1) {
                    ans -= 2;
                }
            }
        }
        return ans;
    }
}