class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return solve(text1, text2, 0, 0);

        // int[][] dp = new int[text1.length()+1][text2.length()+1];

        // for(int i=text1.length()-1; i>=0; i--) {
        //     for(int j=text2.length()-1; j>=0; j--) {
        //         if(text1.charAt(i)==text2.charAt(j)) {
        //             dp[i][j] = dp[i+1][j+1] + 1;
        //         } else {
        //             dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
        //         }
        //     }
        // }

        // return dp[0][0];

        if(text1.length() < text2.length()) {
            return longestCommonSubsequence(text2, text1);
        }

        int[] dp = new int[text2.length()+1];
        dp[text2.length()] = 0;

        for(int i=text1.length()-1; i>=0; i--) {
            int[] newDp = new int[text2.length()+1];
            for(int j=text2.length()-1; j>=0; j--) {
                if(text1.charAt(i)==text2.charAt(j)) {
                    newDp[j] = dp[j+1] + 1;
                } else {
                    newDp[j] = Math.max(dp[j], newDp[j+1]);
                }
            }
            dp = newDp;
        }
        return dp[0];
    }

    // private int solve(String s, String t, int i, int j) {
    //     if(i==s.length() || j==t.length()) {
    //         return 0;
    //     }


    //     if(s.charAt(i)==t.charAt(j)) {
    //         return solve(s, t, i+1, j+1)+1;
    //     }

    //     return Math.max(solve(s, t, i+1, j), solve(s, t, i, j+1));
    // }
}
