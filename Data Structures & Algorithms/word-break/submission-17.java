class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int maxLen = 0;
        for(String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j <= Math.min(i + maxLen, s.length()); j++) {
                if(words.contains(s.substring(i, j))) {
                    dp[i] |= dp[j];
                }
                if(dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
