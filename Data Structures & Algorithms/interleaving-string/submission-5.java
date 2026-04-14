class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) {
            return false;
        }
        // boolean[] dp = new boolean[s2.length()+1];
        // dp[s2.length()] = true;
        // boolean[] newDp = Arrays.copyOfRange(dp, 0, s2.length()+1);

        // for(int i=s1.length(); i>=0; i--) {
        //     for(int j=s2.length(); j>=0; j--) {
        //         int k = i+j;
        //         if(i<s1.length() && s1.charAt(i)==s3.charAt(k)) {
        //             newDp[j] |= dp[j];
        //         }
        //         if(j<s2.length() && s2.charAt(j)==s3.charAt(k)) {
        //             newDp[j] |= newDp[j+1];
        //         }
        //     }
        //     dp = newDp;
        // }
        // return dp[0];
        // return solve(s1, s2, s3, 0, 0, 0);
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[s1.length()][s2.length()] = true;

        for(int i=s1.length(); i>=0; i--) {
            for(int j=s2.length(); j>=0; j--) {
                int k = i+j;
                if(i<s1.length() && s1.charAt(i)==s3.charAt(k)) {
                    dp[i][j] |= dp[i+1][j];
                }
                if(j<s2.length() && s2.charAt(j)==s3.charAt(k)) {
                    dp[i][j] |= dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }

    // private boolean solve(String s1, String s2, String s3, int i, int j, int k) {
    //     if(i==s1.length() && j==s2.length()) {
    //         return true;
    //     }

    //     ans = false;

    //     if(i<s1.length() && s1.charAt(i)==s3.charAt(k)) {
    //         ans |= solve(s1, s2, s3, i+1, j, k+1);
    //     }

    //     if(j<s2.length() && s2.charAt(j)==s3.charAt(k)) {
    //         ans |= solve(s1, s2, s3, i, j+1, k+1);
    //     }

    //     return ans;
    // }
}
