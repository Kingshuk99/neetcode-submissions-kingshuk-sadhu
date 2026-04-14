class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> profits = new HashMap<>();
        return maxProfitUtil(prices, profits, true, 0);
    }

    private int maxProfitUtil(int[]prices, Map<String, Integer> profits, 
    boolean buy, int ind) {
        if(ind>=prices.length) {
            return 0;
        }
        String key = ind+"-"+buy;

        if(profits.containsKey(key)) {
            return profits.get(key);
        }

        int cooldown = maxProfitUtil(prices, profits, buy, ind+1);
        int profit = 0;
        if(buy) {
            profit = maxProfitUtil(prices, profits, !buy, ind+1) - prices[ind];
        } else {
            profit = maxProfitUtil(prices, profits, !buy, ind+2) + prices[ind];
        }

        profits.put(key, Math.max(profit, cooldown));
        return profits.get(key);
    }
}
