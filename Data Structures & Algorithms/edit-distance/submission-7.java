class Solution {
    public int minDistance(String word1, String word2) {
        // return solve(word1, word2, 0, 0);
        int[] dp = new int[word2.length() + 1];

        // for(int i = word1.length() - 1; i >= 0; i--) {
        //     dp[i][word2.length()] = 1 + dp[i + 1][word2.length()];
        // }

        for(int i = word2.length() - 1; i >= 0; i--) {
            dp[i] = 1 + dp[i + 1];
        }

        for(int i = word1.length() - 1; i >= 0; i--) {
            // int[] newDp = new int[word2.length() + 1];
            // newDp[word2.length()] = dp[word2.length()] + 1;

            int oldNextDp = dp[word2.length()];
            dp[word2.length()] += 1;

            for(int j = word2.length() - 1; j >= 0; j--) {
                int currDp = dp[j];
                dp[j] = oldNextDp;
                if(word1.charAt(i) == word2.charAt(j)) {
                    oldNextDp = currDp;
                    continue;
                }

                dp[j] = 1 + Math.min(dp[j], 
                Math.min(currDp, dp[j + 1]));

                oldNextDp = currDp;
            }
            // dp = Arrays.copyOf(newDp, newDp.length);
        }

        return dp[0];
    }

    // private int solve(String s, String t, int i, int j) {
    //     if(i == s.length() && j == t.length()) {
    //         return 0;
    //     }

    //     if(i == s.length()) {
    //         return 1 + solve(s, t, i, j + 1);
    //     }

    //     if(j == t.length()) {
    //         return 1 + solve(s, t, i + 1, j);
    //     }

    //     if(s.charAt(i) == t.charAt(j)) {
    //         return solve(s, t, i + 1, j + 1);
    //     }

    //     return 1 + Math.min(solve(s, t, i, j + 1), 
    //     Math.min(solve(s, t, i + 1, j + 1), solve(s, t, i + 1, j)));
    // }
}
