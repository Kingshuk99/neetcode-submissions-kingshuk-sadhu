class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int total = 1; total <= amount; total++) {
            for(int coin : coins) {
                if(coin > total) {
                    break;
                }
                if(dp[total - coin] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[total] = Math.min(dp[total], dp[total - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
