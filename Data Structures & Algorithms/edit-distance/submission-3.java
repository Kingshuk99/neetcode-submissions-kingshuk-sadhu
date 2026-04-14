class Solution {
    public int minDistance(String word1, String word2) {
        // Sol 1
        // return solve(word1, word2, 0, 0);

        //Sol2
        // int m = word1.length(), n = word2.length();
        // int[][] dp = new int[m+1][n+1];

        // for(int i=m; i>=0; i--) {
        //     for(int j=n; j>=0; j--) {
        //         if(i==m && j==n) {
        //             dp[i][j] = 0;
        //             continue;
        //         }
                
        //         if(i==m) {
        //             dp[i][j] = n-j;
        //             continue;
        //         }

        //         if(j==n) {
        //             dp[i][j] = m-i;
        //             continue;
        //         }

        //         if(word1.charAt(i)==word2.charAt(j)) {
        //             dp[i][j] = dp[i+1][j+1];
        //             continue;
        //         }

        //         dp[i][j] = Math.min(dp[i+1][j+1], 
        //         Math.min(dp[i+1][j], dp[i][j+1])) + 1;
        //     }
        // }

        // return dp[0][0];

        //Sol3
        // int m = word1.length(), n = word2.length();
        // int[][] dp = new int[m+1][n+1];

        // for(int i=0; i<=m; i++) {
        //     for(int j=0; j<=n; j++) {
        //         if(i==0 && j==0) {
        //             dp[i][j] = 0;
        //             continue;
        //         }

        //         if(i==0) {
        //             dp[i][j] = j;
        //             continue;
        //         }

        //         if(j==0) {
        //             dp[i][j] = i;
        //             continue;
        //         }

        //         if(word1.charAt(i-1)==word2.charAt(j-1)) {
        //             dp[i][j] = dp[i-1][j-1];
        //             continue;
        //         }

        //         dp[i][j] = Math.min(dp[i-1][j-1], 
        //         Math.min(dp[i-1][j], dp[i][j-1])) + 1;
        //     }
        // }

        // return dp[m][n];

        //Sol 4
        int m = word1.length(), n = word2.length();
        if(m < n) {
            return minDistance(word2, word1);
        }
        int[] dp = new int[n+1];
        for(int i=0; i<=n; i++) {
            dp[i] = i;
        }

        for(int i=1; i<=m; i++) {
            int[] newDp = new int[n+1];
            newDp[0] = i;
            for(int j=1; j<=n; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    newDp[j] = dp[j-1];
                    continue;
                }

                newDp[j] = Math.min(dp[j-1], 
                Math.min(dp[j], newDp[j-1])) + 1;
            }
            dp = newDp;
        }

        return dp[n];
    }

    // private int solve(String word1, String word2, int i, int j) {
    //     if(i==word1.length() && j==word2.length()) {
    //         return 0;
    //     }
    //     if(i==word1.length()) {
    //         return word2.length()-j;
    //     }

    //     if(j==word2.length()) {
    //         return word1.length()-i;
    //     }

    //     if(word1.charAt(i)==word2.charAt(j)) {
    //         return solve(word1, word2, i+1, j+1);
    //     }

    //     return Math.min(solve(word1, word2, i+1, j+1), 
    //     Math.min(solve(word1, word2, i+1, j), solve(word1, word2, i, j+1)))+1;
    // }
}
