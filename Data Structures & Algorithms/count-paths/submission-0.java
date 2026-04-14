class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=1; i<m; i++) {
            int[] newDp = new int[n];
            Arrays.fill(newDp, 1);
            for(int j=1; j<n; j++) {
                newDp[j] = newDp[j-1]+dp[j];
            }
            dp = newDp;
        }

        return dp[n-1];
    }
}
