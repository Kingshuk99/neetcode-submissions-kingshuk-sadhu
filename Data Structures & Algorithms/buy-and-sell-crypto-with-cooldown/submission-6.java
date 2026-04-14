class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, buy1 = 0, sell1 = 0, buy2 = 0;

        for(int i=n-1; i>=0; i--) {
            int buy = Math.max(sell1-prices[i], buy1);
            int sell = Math.max(buy2+prices[i], sell1);
            buy2 = buy1;
            buy1 = buy;
            sell1 = sell;
        }

        return buy1;
    }
}
