class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return solve(text1, text2, 0, 0, 0);
        int[] dp = new int[text2.length()+1];
        for(int i=text1.length()-1; i>=0; i--) {
            int[] newDp = new int[text2.length()+1];
            for(int j=text2.length()-1; j>=0; j--) {
                if(text1.charAt(i)==text2.charAt(j)) {
                    newDp[j] = 1 + dp[j+1];
                    continue;
                }
                newDp[j] = Math.max(newDp[j+1], dp[j]);
            }
            dp = newDp;
        }

        return dp[0];
    }

    // private int solve(String s1, String s2, int i, int j, int len) {
    //     if(i==s1.length() || j==s2.length()) {
    //         return len;
    //     }

    //     if(s1.charAt(i)==s2.charAt(j)) {
    //         return solve(s1, s2, i+1, j+1, len+1);
    //     } else {
    //         return Math.max(solve(s1, s2, i, j+1, len), 
    //         solve(s1, s2, i+1, j, len));
    //     }
    // }
}
