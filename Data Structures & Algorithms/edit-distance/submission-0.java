class Solution {
    public int minDistance(String word1, String word2) {
        int dp[] = new int[word1.length()+1];

        for(int i=0; i<dp.length; i++) {
            dp[i] = i;
        }

        for(int i=1; i<=word2.length(); i++) {
            int[] newDp = new int[word1.length()+1];

            newDp[0] = i;

            for(int j=1; j<=word1.length(); j++) {
                if(word1.charAt(j-1)==word2.charAt(i-1)) {
                    newDp[j] = dp[j-1];
                    continue;
                }
                newDp[j] = Math.min(newDp[j-1], Math.min(dp[j-1], dp[j])) + 1;
            }

            dp = newDp;
        }

        return dp[word1.length()];
    }
}
