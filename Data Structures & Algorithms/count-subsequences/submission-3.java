class Solution {
    public int numDistinct(String s, String t) {
        // return solve(s, t, 0, 0);
        if(s.length() < t.length()) {
            return 0;
        }

        int[] dp = new int[t.length()+1];
        dp[t.length()] = 1;

        for(int i=s.length()-1; i>=0; i--) {
            int[] newDp = new int[t.length()+1];
            newDp[t.length()] = 1;
            for(int j=t.length()-1; j>=0; j--) {
                if(s.charAt(i)==t.charAt(j)) {
                    newDp[j] += dp[j+1];
                }
                newDp[j] += dp[j];
            }
            dp = newDp;
        }

        return dp[0];
    }

    // private int solve(String s, String t, int i, int j) {
    //     if(j==t.length()) {
    //         return 1;
    //     }
    //     if(i==s.length()) {
    //         return 0;
    //     }

    //     int ans = 0;
    //     if(s.charAt(i)==t.charAt(j)) {
    //         ans += solve(s, t, i+1, j+1);
    //     }

    //     ans += solve(s, t, i+1, j);

    //     return ans;
    // }
}
