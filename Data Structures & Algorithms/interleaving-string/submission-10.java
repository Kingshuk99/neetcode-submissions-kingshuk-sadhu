class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[s1.length()][s2.length()] = true;

        for(int i=s1.length(); i>=0; i--) {
            for(int j=s2.length(); j>=0; j--) {
                int k = i+j;
                if(i<s1.length() && s1.charAt(i)==s3.charAt(k)) {
                    dp[i][j] = dp[i+1][j];
                }
                if(dp[i][j]) {
                    continue;
                }
                if(j<s2.length() && s2.charAt(j)==s3.charAt(k)) {
                    dp[i][j] = dp[i][j+1];
                }
            }
        }

        return dp[0][0];
    }
}
