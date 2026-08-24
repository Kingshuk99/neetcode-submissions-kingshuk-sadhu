class Solution {
    public int maxProfit(int[] prices) {
        // return dfs(prices, 0, false);
        // int[][] dp = new int[prices.length + 1][2];
        int prevBought = 0, currBought = 0, prevNotBought = 0, currNotBought = 0;

        // for(int i = prices.length - 1; i >= 0; i--) {
        //     currBought = Math.max(prevBought, prevNotBought + prices[i]);
        //     currNotBought = Math.max(prevNotBought, prevBought - prices[i]);
        //     prevBought = currBought;
        //     prevNotBought = currNotBought;
        // }
        // return prevNotBought;

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;

    }

    // private int dfs(int[] prices, int ind, boolean bought) {
    //     if(ind == prices.length) {
    //         return 0;
    //     }

    //     if(bought) {
    //         return Math.max(dfs(prices, ind + 1, bought), dfs(prices, ind + 1, !bought) + prices[ind]);
    //     }
    //     return Math.max(dfs(prices, ind + 1, bought), dfs(prices, ind + 1, !bought) - prices[ind]);
    // }
}