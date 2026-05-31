class Solution {
    public boolean isMatch(String s, String p) {
        // return solve(s, p, 0, 0);

        boolean[] dp = new boolean[p.length() + 1];
        dp[p.length()] = true;

        for(int i = s.length(); i >= 0; i--) {
            // boolean[] newDp = new boolean[p.length() + 1];
            // newDp[p.length()] = (i == s.length());
            boolean nextDp = dp[p.length()];
            dp[p.length()] = (i == s.length());
            for(int j = p.length() - 1; j >= 0; j--) {
                boolean curr = dp[j];
                boolean firstMatch = (i < s.length() && 
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[j] = dp[j + 2] || (firstMatch && curr);
                    nextDp = curr;
                    continue;
                }

                if (firstMatch) {
                    dp[j] = nextDp;
                } else {
                    dp[j] = false;
                }
                nextDp = curr;
            }
            // dp = Arrays.copyOf(newDp, newDp.length);
        }

        return dp[0];
    }

    // private boolean solve(String s, String p, int i, int j) {
    //     if(j == p.length()) {
    //         return i == s.length();
    //     }

    //     boolean firstMatch = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

    //     if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
    //         return solve(s, p, i, j + 2) || (firstMatch && solve(s, p, i + 1, j));
    //     }

    //     if (firstMatch) {
    //         return solve(s, p, i + 1, j + 1);
    //     }
    //     return false;
    // }
}
