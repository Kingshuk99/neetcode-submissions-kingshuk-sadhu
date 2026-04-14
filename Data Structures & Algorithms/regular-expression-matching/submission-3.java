class Solution {
    public boolean isMatch(String s, String p) {
        // Sol 1
        // return solve(s, p, s.length(), p.length());

        // Sol 2
        // boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        // for(int i=0; i<=s.length(); i++) {
        //     for(int j=0; j<=p.length(); j++) {
        //         if(i==0 && j==0) {
        //             dp[i][j] = true;
        //             continue;
        //         }

        //         if(j==0) {
        //             dp[i][j] = false;
        //             continue;
        //         }

        //         if(i==0) {
        //             dp[i][j] = p.charAt(j-1)=='*' && dp[i][j-2];
        //             continue;
        //         }

        //         if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') {
        //             dp[i][j] = dp[i-1][j-1];
        //             continue;
        //         }

        //         if(p.charAt(j-1)=='*') {
        //             dp[i][j] = dp[i][j-2] || 
        //             ((s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.') && 
        //             dp[i-1][j]);
        //         }
        //     }
        // }
        // return dp[s.length()][p.length()];

        // Sol 3
        boolean[] dp = new boolean[p.length()+1];
        dp[0] = true;
        for(int j=1; j<=p.length(); j++) {
            dp[j] = p.charAt(j-1)=='*' && dp[j-2];
        }

        for(int i=1; i<=s.length(); i++) {
            boolean[] newDp = new boolean[p.length()+1];
            for(int j=1; j<=p.length(); j++) {
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') {
                    newDp[j] = dp[j-1];
                    continue;
                }

                if(p.charAt(j-1)=='*') {
                    newDp[j] = newDp[j-2] || 
                    ((s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.') && 
                    dp[j]);
                }
            }
            dp = newDp;
        }
        return dp[p.length()];
    }

    // private boolean solve(String s, String p, int i, int j) {
    //     if(i==0 && j==0) {
    //         return true;
    //     }

    //     if(j==0) {
    //         return false;
    //     }

    //     if(i==0) {
    //         return p.charAt(j-1)=='*' && solve(s, p, i, j-2);
    //     }

    //     if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') {
    //         return solve(s, p, i-1, j-1);
    //     }

    //     if(p.charAt(j-1)=='*') {
    //         return solve(s, p, i, j-2) || 
    //         ((s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.') && 
    //         solve(s, p, i-1, j));
    //     }

    //     return false;
    // }
}
