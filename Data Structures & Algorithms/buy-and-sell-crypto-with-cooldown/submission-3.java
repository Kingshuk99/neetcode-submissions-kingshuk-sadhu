class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> dp = new HashMap<>();
        return solve(prices, 0, true, dp);
    }

    private int solve(int[] prices, int ind, boolean buying, 
    Map<String, Integer> dp) {
        if(ind>=prices.length) {
            return 0;
        }
        String key = ind + "-" + buying;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int profit = solve(prices, ind+1, buying, dp);
        if(buying) {
            profit = Math.max(profit, 
            solve(prices, ind+1, !buying, dp)-prices[ind]);
        } else {
            profit = Math.max(profit, 
            solve(prices, ind+2, !buying, dp)+prices[ind]);
        }

        dp.put(key, profit);
        return profit;
    }
}
