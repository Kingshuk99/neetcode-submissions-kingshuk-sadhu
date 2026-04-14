class Solution {
    public int numDistinct(String s, String t) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, 1);

        for(int i=1; i<=t.length(); i++) {
            int[] newDp = new int[s.length()+1];

            for(int j=1; j<=s.length(); j++) {
                newDp[j] = newDp[j-1];
                if(s.charAt(j-1)==t.charAt(i-1)) {
                    newDp[j] += dp[j-1];
                }
            }

            dp = newDp;
        }

        return dp[s.length()];
    }
}
