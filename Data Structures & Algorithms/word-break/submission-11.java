class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int maxLen = 0;
        for(String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }
        // return solve(s, words, 0, maxLen);

        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        for(int i=s.length()-1; i>=0; i--) {
            for(int j=i+1; j<=Math.min(i+maxLen, s.length()); j++) {
                if(words.contains(s.substring(i, j)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    // private boolean solve(String s, Set<String> words, int start, int maxLen) {
    //     if(start==s.length()) {
    //         return true;
    //     }
        
    //     for(int end=start+1; end<=Math.min(s.length(), start + maxLen); end++) {
    //         if(words.contains(s.substring(start, end)) && 
    //         solve(s, words, end, maxLen)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
