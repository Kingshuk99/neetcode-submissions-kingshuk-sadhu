class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int curr=1; curr<=amount; curr++) {
            for(int i=0; i<coins.length; i++) {
                if(coins[i]>curr) {
                    continue;
                }
                int prev = dp[curr-coins[i]]!=Integer.MAX_VALUE?
                dp[curr-coins[i]]+1:Integer.MAX_VALUE;
                dp[curr] = Math.min(dp[curr], prev);
            }
        }

        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
