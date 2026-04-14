class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int len = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                solve(matrix, i, j, dp, dirs);
                len = Math.max(len, dp[i][j]);
            }
        }

        return len;
    }

    private int solve(int[][] matrix, int r, int c, int[][] dp, int[][] dirs) {
        if(dp[r][c]!=0) {
            return dp[r][c];
        }

        for(int k=0; k<4; k++) {
            int[] dir = dirs[k];
            int x = r + dir[0], y = c + dir[1];
            if(x<0 || x>=matrix.length || y<0 || y>=matrix[0].length || 
            matrix[r][c]>=matrix[x][y]) {
                continue;
            }
            dp[r][c] = Math.max(dp[r][c], solve(matrix, x, y, dp, dirs));
        }
        dp[r][c] += 1;
        return dp[r][c];
    }
}
