class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        int t = 0;
        for(String word : wordDict) {
            t = Math.max(t, word.length());
        }
        return dfs(s, wordSet, dp, 0, t);
    }

    private boolean dfs(String s, Set<String> wordSet, Boolean[] dp, int i, int t) {
        if(i==s.length()) {
            return true;
        }

        if(dp[i]!=null) {
            return dp[i];
        }

        for(int j=i; j<Math.min(i+t, s.length()); j++) {
            if(wordSet.contains(s.substring(i, j+1)) && 
            dfs(s, wordSet, dp, j+1, t)) {
                dp[i] = true;
                return true;
            }
        }

        dp[i] = false;
        return false;
    }
}
