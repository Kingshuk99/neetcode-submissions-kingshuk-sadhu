class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) {
            return false;
        }
        // return solve(s1, s2, s3, 0, 0);
        
        // boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];

        // for(int i=s1.length(); i>=0; i--) {
        //     for(int j=s2.length(); j>=0; j--) {
        //         if(i==s1.length() && j==s2.length()) {
        //             dp[i][j] = true;
        //             continue;
        //         }
        //         int k = i+j;
        //         if(i<s1.length() && s1.charAt(i)==s3.charAt(k) && dp[i+1][j]) {
        //             dp[i][j] = true;
        //             continue;
        //         }
        //         dp[i][j] = j<s2.length() && s2.charAt(j)==s3.charAt(k) && 
        //         dp[i][j+1];
        //     }
        // }

        // return dp[0][0];

        if(s1.length()<s2.length()) {
            return isInterleave(s2, s1, s3);
        }

        boolean[] dp = new boolean[s2.length()+1];

        for(int i=s1.length(); i>=0; i--) {
            boolean[] newDp = new boolean[s2.length()+1];
            for(int j=s2.length(); j>=0; j--) {
                if(i==s1.length() && j==s2.length()) {
                    newDp[j] = true;
                    continue;
                }
                int k = i+j;
                if(i<s1.length() && s1.charAt(i)==s3.charAt(k) && dp[j]) {
                    newDp[j] = true;
                    continue;
                }
                newDp[j] = j<s2.length() && s2.charAt(j)==s3.charAt(k) && 
                newDp[j+1];
            }
            dp = newDp;
        }
        return dp[0];
    }

    // private boolean solve(String s1, String s2, String s3, int i, int j) {
    //     if(i==s1.length() && j==s2.length()) {
    //         return true;
    //     }

    //     int k = i+j;
    //     if(i<s1.length() && s1.charAt(i)==s3.charAt(k) && 
    //     solve(s1, s2, s3, i+1, j)) {
    //         return true;
    //     }
    //     return j<s2.length() && s2.charAt(j)==s3.charAt(k) && 
    //     solve(s1, s2, s3, i, j+1);
    // }
}
