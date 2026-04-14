class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        int[][] dir = new int[4][2];
        dir[0][0] = 0;
        dir[0][1] = -1;
        dir[1][0] = -1;
        dir[1][1] = 0;
        dir[2][0] = 0;
        dir[2][1] = 1;
        dir[3][0] = 1;
        dir[3][1] = 0;

        int ans = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, dp, dir));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp, int[][] dir) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }

        for(int k=0; k<dir.length; k++) {
            int x = i+dir[k][0], y = j+dir[k][1];
            if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && 
            matrix[x][y]>matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], dfs(matrix, x, y, dp, dir));
            }
        }

        dp[i][j] += 1;
        return dp[i][j];
    }
}
