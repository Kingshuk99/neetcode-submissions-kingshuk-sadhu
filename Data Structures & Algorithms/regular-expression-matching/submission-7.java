class Solution {
    public boolean isMatch(String s, String p) {
        // return solve(s, p, 0, 0);

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for(int i = s.length(); i >= 0; i--) {
            for(int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = (i < s.length() && 
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                    continue;
                }

                if (firstMatch) {
                    dp[i][j] = dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }

    // private boolean solve(String s, String p, int i, int j) {
    //     if(j == p.length()) {
    //         return i == s.length();
    //     }

    //     boolean firstMatch = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

    //     if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
    //         return solve(s, p, i, j + 2) || (firstMatch && solve(s, p, i + 1, j));
    //     }

    //     if (firstMatch) {
    //         return solve(s, p, i + 1, j + 1);
    //     }
    //     return false;
    // }
}
