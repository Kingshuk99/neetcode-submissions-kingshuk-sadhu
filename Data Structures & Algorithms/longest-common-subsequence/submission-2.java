class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text2.length()+1];
        for(int i=1; i<=text1.length(); i++) {
            int[] newDp = new int[text2.length()+1];
            for(int j=1; j<=text2.length(); j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    newDp[j] = dp[j-1]+1;
                    continue;
                }
                newDp[j] = Math.max(newDp[j-1], dp[j]);
            }
            dp = newDp;
        }
        return dp[text2.length()];
    }
}
