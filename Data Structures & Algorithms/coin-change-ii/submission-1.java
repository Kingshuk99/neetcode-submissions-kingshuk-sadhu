class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int coin : coins) {
            int[] newDp = new int[amount+1];
            for(int i=0; i<=amount; i++) {
                newDp[i] = dp[i];
                if(i<coin) {
                    continue;
                }
                newDp[i] += newDp[i-coin];
            }
            dp = newDp;
        }

        return dp[amount];
    }
}
