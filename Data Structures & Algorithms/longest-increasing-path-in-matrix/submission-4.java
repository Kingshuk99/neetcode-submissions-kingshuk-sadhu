class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{-1, 0, 1, 0};
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                ans = Math.max(ans, calculatePath(matrix, dp, i, j, dx, dy));
            }
        }
        return ans;
    }

    private int calculatePath(int[][] matrix, int[][] dp, int i, int j, 
    int[] dx, int[] dy) {
        if(dp[i][j]!=0) {
            return dp[i][j];
        }

        for(int k=0; k<4; k++) {
            int x = i+dx[k], y = j+dy[k];
            if(x<0 || y<0 || x>=matrix.length || y>=matrix[0].length || 
            matrix[x][y]>=matrix[i][j]) {
                continue;
            }
            dp[i][j] = Math.max(dp[i][j], calculatePath(matrix, dp, x, y, dx, dy));
        }
        dp[i][j] += 1;
        return dp[i][j];
    }
}
