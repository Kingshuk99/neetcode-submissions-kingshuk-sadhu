class Solution {
    public boolean isMatch(String s, String p) {
        // return solve(s, p, 0, 0);

        boolean[] dp = new boolean[p.length() + 1];

        for(int i = s.length(); i >= 0; i--) {
            boolean[] newDp = new boolean[p.length() + 1];
            newDp[p.length()] = (i == s.length());
            for(int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = (i < s.length() && 
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    newDp[j] = newDp[j + 2] || (firstMatch && dp[j]);
                    continue;
                }

                if (firstMatch) {
                    newDp[j] = dp[j + 1];
                }
            }
            dp = Arrays.copyOf(newDp, newDp.length);
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
