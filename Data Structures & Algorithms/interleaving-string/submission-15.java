class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // return solve(s1, 0, s2, 0, s3);
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;

        for(int i = s1.length() - 1; i >= 0; i--) {
            int k = i + s2.length();
            dp[i][s2.length()] = s1.charAt(i) == s3.charAt(k) && 
            dp[i + 1][s2.length()];
        }

        for(int i = s2.length() - 1; i >= 0; i--) {
            int k = i + s1.length();
            dp[s1.length()][i] = s2.charAt(i) == s3.charAt(k) && 
            dp[s1.length()][i + 1];
        }

        for(int i = s1.length() - 1; i >= 0; i--) {
            for(int j = s2.length() - 1; j >= 0; j--) {
                int k = i + j;
                if(s1.charAt(i) == s3.charAt(k)) {
                    dp[i][j] |= dp[i + 1][j]; 
                }

                if(s2.charAt(j) == s3.charAt(k)) {
                    dp[i][j] |= dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }

    // private boolean solve(String s1, int i, String s2, int j, 
    // String s3) {
    //     int k = i + j;
    //     if(i == s1.length() && j == s2.length() && k == s3.length()) {
    //         return true;
    //     }

    //     if(i == s1.length()) {
    //         return s2.charAt(j) == s3.charAt(k) && 
    //         solve(s1, i, s2, j + 1, s3);
    //     }

    //     if(j == s2.length()) {
    //         return s1.charAt(i) == s3.charAt(k) && 
    //         solve(s1, i + 1, s2, j, s3);
    //     }

    //     boolean matches = false;

    //     if(s1.charAt(i) == s3.charAt(k)) {
    //         matches |= solve(s1, i + 1, s2, j, s3); 
    //     }

    //     if(s2.charAt(j) == s3.charAt(k)) {
    //         matches |= solve(s1, i, s2, j + 1, s3);
    //     }

    //     return matches;
    // }
}
