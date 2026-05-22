class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        // return solve(amount, coins, 0);

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = coins.length - 1; i >= 0; i--) {
            for(int j = 1; j <= amount; j++) {
                if(coins[i] > j) {
                    continue;
                }
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    // private int solve(int amount, int[] coins, int i) {
    //     if(amount == 0) {
    //         return 1;
    //     }

    //     if(i == coins.length || coins[i] > amount) {
    //         return 0;
    //     }

    //     return solve(amount, coins, i + 1) + 
    //     solve(amount - coins[i], coins, i);
    // }
}
