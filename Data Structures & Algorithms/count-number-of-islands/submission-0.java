class Solution {
    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '2';
        int m = grid.length, n = grid[0].length;
        if(j>0 && grid[i][j-1]=='1') {
            dfs(grid, i, j-1);
        }
        if(i>0 && grid[i-1][j]=='1') {
            dfs(grid, i-1, j);
        }
        if(j<n-1 && grid[i][j+1]=='1') {
            dfs(grid, i, j+1);
        }
        if(i<m-1 && grid[i+1][j]=='1') {
            dfs(grid, i+1, j);
        }
    }
    public int numIslands(char[][] grid) {
        int count  = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
