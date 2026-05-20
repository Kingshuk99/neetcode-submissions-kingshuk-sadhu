class Solution {
    public int uniquePaths(int m, int n) {
        // return solve(0, 0, m, n);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int r = m - 2; r >= 0; r--) {
            for(int c = n - 2; c >= 0; c--) {
                dp[c] += dp[c + 1];
            }
        }

        return dp[0];
    }
}
