class Solution {
    private int dfs(int[][] grid, int i, int j, int area) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1) {
            return area;
        }
        grid[i][j] = 2;
        area++;
        area = dfs(grid, i, j-1, area);
        area = dfs(grid, i-1, j, area);
        area = dfs(grid, i, j+1, area);
        area = dfs(grid, i+1, j, area);

        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    ans = Math.max(ans, dfs(grid, i, j, 0));
                }
            }
        }
        return ans;
    }
}
