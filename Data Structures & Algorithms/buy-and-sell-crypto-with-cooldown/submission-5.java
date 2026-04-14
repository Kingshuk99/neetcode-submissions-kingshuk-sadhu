class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> dp = new HashMap<>();
        return calculateProfit(prices, 0, true, dp);
    }

    private int calculateProfit(int[] prices, int ind, boolean buying, 
    Map<String, Integer> dp) {
        String key = ind + "-" + buying;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        if(ind >= prices.length) {
            return 0;
        }

        int profit = calculateProfit(prices, ind+1, buying, dp);
        if(buying) {
            profit = Math.max(profit, 
            calculateProfit(prices, ind+1, !buying, dp)-prices[ind]);
        } else {
            profit = Math.max(profit, 
            calculateProfit(prices, ind+2, !buying, dp)+prices[ind]);
        }
        dp.put(key, profit);
        return profit;
    }
}
