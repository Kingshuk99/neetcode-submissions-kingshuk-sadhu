class Solution {
    private int[][] dp;
    private int ans = 0;
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];

        for(int[] row : dp) {
            Arrays.fill(row, 0);
        }


        for(int i = 0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                ans = Math.max(ans, dfs(i, j, matrix));
            }
        }

        return ans;
    }

    private int dfs(int i, int j, int[][] matrix) {
        if(dp[i][j]!=0) {
            return dp[i][j];
        }
        
        dp[i][j] = 1;

        if(i>0 && matrix[i-1][j]>matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], dfs(i-1, j, matrix)+1);
        }

        if(j<matrix[0].length-1 && matrix[i][j+1]>matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], dfs(i, j+1, matrix)+1);
        }

        if(i<matrix.length-1 && matrix[i+1][j]>matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], dfs(i+1, j, matrix)+1);
        }
        if(j>0 && matrix[i][j-1]>matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], dfs(i, j-1, matrix)+1);
        }

        return dp[i][j];
    }
}
