class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // return solve(s, 0, wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;

        for(int i=s.length()-1; i>=0; i--) {
            for(String word : wordDict) {
                if(i+word.length()<=s.length() && 
                s.substring(i, i+word.length()).equals(word) && dp[i+word.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
    // private boolean solve(String s, int i, List<String> wordDict) {
    //     if(i==s.length()) {
    //         return true;
    //     }

    //     for(String word : wordDict) {
    //         if(i+word.length()<=s.length() && 
    //         s.substring(i, i+word.length()).equals(word) && 
    //         solve(s, i+word.length(), wordDict)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
