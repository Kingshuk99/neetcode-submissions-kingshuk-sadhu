class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = 0;
        for(String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        // return solve(s, words, 0, maxLen, dp);
        dp[s.length()] = true;
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j <= Math.min(s.length(), i + maxLen); 
            j++) {
                if(words.contains(s.substring(i, j)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    // private boolean solve(String s, Set<String> words, int ind, 
    // int maxLen, boolean[] dp) {
    //     if(ind == s.length()) {
    //         dp[ind] = true;
    //         return true;
    //     }

    //     for(int i = ind + 1; i <= Math.min(s.length(), ind + maxLen);
    //     i++) {
    //         if(words.contains(s.substring(ind, i)) && 
    //         solve(s, words, i, maxLen, dp)) {
    //             dp[ind] = true;
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
