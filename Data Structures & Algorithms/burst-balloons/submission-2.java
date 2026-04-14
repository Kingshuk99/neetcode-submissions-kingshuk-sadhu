class Solution {
    public int maxCoins(int[] nums) {
        int[] coins = new int[nums.length+2];

        coins[0] = coins[nums.length+1] = 1;

        for(int i=1; i<=nums.length; i++) {
            coins[i] = nums[i-1];
        }

        int[][] dp = new int[coins.length][coins.length];
        dp[0][0] = 1;

        for(int i=1; i<=nums.length; i++){
            dp[i][i] = coins[i-1]*coins[i]*coins[i+1];
        }

        for(int len=2; len<=nums.length; len++) {
            for(int l=1; l<=nums.length-len+1; l++) {
                int r = l+len-1;

                for(int i=l; i<=r; i++) { //burst ith at last
                    int coin = coins[l-1]*coins[i]*coins[r+1];
                    dp[l][r] = Math.max(dp[l][r], dp[l][i-1]+coin+dp[i+1][r]);
                }
            }
        }

        return dp[1][nums.length];
    }
}
