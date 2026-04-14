class Solution {
    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length()+1];

        for(int i=0; i<=word2.length(); i++) {
            dp[i] = i;
        }

        for(int i=1; i<=word1.length(); i++) {
            int[] newDp = new int[word2.length()+1];
            newDp[0] = i;
            for(int j=1; j<=word2.length(); j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    newDp[j] = dp[j-1];
                } else {
                    newDp[j] = Math.min(dp[j-1], 
                    Math.min(dp[j], newDp[j-1]))+1;
                }
            }
            dp = newDp;
        }

        return dp[word2.length()];
    }
}
