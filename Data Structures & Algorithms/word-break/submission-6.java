class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // return solve(s, 0, wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;

        for(int i=s.length()-1; i>=0; i--) {
            for(String word : wordDict) {
                if(i+word.length() > s.length()) {
                    continue;
                }
                if(s.substring(i, i+word.length()).equals(word)) {
                    dp[i] |= dp[i+word.length()];
                    if(dp[i]) {
                        break;
                    }
                }
            }
        }
        return dp[0];
    }

    // private boolean solve(String s, int ind, List<String> wordDict) {
    //     if(ind==s.length()) {
    //         return true;
    //     }

    //     for(String word : wordDict) {
    //         if(ind+word.length() > s.length()) {
    //             continue;
    //         }
    //         if(s.substring(ind, ind+word.length()).equals(word) && 
    //         solve(s, ind+word.length(), wordDict)) {
    //             return true;
    //         } 
    //     }

    //     return false;
    // }
}
