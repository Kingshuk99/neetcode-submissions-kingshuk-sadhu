class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, dp));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if(dp[i][j]!=0) {
            return dp[i][j];
        }

        dp[i][j] = 1;

        if(i>0 && matrix[i-1][j]>matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i-1, j, dp)+1);
        }
        if(j>0 && matrix[i][j-1]>matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i, j-1, dp)+1);
        }
        if(i<matrix.length-1 && matrix[i+1][j]>matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i+1, j, dp)+1);
        }
        if(j<matrix[0].length-1 && matrix[i][j+1]>matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i, j+1, dp)+1);
        }

        return dp[i][j];
    }
}
