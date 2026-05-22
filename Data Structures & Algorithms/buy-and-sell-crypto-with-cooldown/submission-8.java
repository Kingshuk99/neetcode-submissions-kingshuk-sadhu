class Solution {
    public int maxProfit(int[] prices) {
        // return solve(prices, 0, false);

        int[] has = new int[prices.length + 2];
        int[] notHas = new int[prices.length + 2];

        for(int i = prices.length - 1; i >= 0; i--) {
            notHas[i] = Math.max(notHas[i + 1], has[i + 1] - prices[i]);
            has[i] = Math.max(notHas[i + 2] + prices[i], has[i + 1]);
        }

        return notHas[0];
    }

    private int solve(int[] prices, int i, boolean has) {
        if(i >= prices.length) {
            return 0;
        }

        if(has == false) {
            return Math.max(solve(prices, i + 1, has), 
            solve(prices, i + 1, !has) - prices[i]);
        }
        return Math.max(prices[i] + solve(prices, i + 2, !has), 
        solve(prices, i + 1, has));
    }
}
