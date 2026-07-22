class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = 0;
        for(String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        Set<String> words = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        // return solve(s, words, 0, maxLen, dp);

        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j <= Math.min(i + maxLen, s.length()); j++) {
                if(words.contains(s.substring(i, j))) {
                    dp[i] |= dp[j];
                    if(dp[i]) {
                        break;
                    }
                }
            }
        }
        return dp[0];
    }

    // private boolean solve(String s, Set<String> words, int ind, int maxLen, boolean[] dp) {
    //     if(ind == s.length()) {
    //         return dp[ind];
    //     }

    //     for(int i = ind + 1; i <= Math.min(ind + maxLen, s.length()); i++) {
    //         if(words.contains(s.substring(ind, i)) && solve(s, words, i, maxLen, dp)) {
    //             return dp[ind] = true;
    //         }
    //     }
    //     return false;
    // }
}
