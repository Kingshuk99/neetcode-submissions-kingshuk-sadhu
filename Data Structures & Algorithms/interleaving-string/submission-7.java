class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // return solve(s1, s2, s3, 0, 0);
        if(s1.length()+s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[s1.length()][s2.length()] = true;
        for(int i=s1.length(); i>=0; i--) {
            for(int j=s2.length(); j>=0; j--) {
                int k = i+j;
                if(i < s1.length() && s1.charAt(i)==s3.charAt(k) && dp[i+1][j]) {
                    dp[i][j] = true;
                    continue;
                }
                if(j < s2.length() && s2.charAt(j)==s3.charAt(k) && dp[i][j+1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }

    // private boolean solve(String s1, String s2, String s3, int i, int j) {
    //     if(i==s1.length() && j==s2.length()) {
    //         return true;
    //     }

    //     int k = i+j;
    //     if(i < s1.length() && s1.charAt(i)==s3.charAt(k) && solve(s1, s2, s3, i+1, j)) {
    //         return true;
    //     }
    //     if(j < s2.length() && s2.charAt(j)==s3.charAt(k) && solve(s1, s2, s3, i, j+1)) {
    //         return true;
    //     }

    //     return false;
    // }
}
