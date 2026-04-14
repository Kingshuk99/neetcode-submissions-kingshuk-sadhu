class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> dp = new HashMap<>();
        return solve(prices, 0, true, dp);
    }

    private int solve(int[] prices, int ind, boolean buying, 
    HashMap<String, Integer> dp) {
        if(ind >= prices.length) {
            return 0;
        }
        String key = ind + "-" + buying;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }
        int cooldown = solve(prices, ind+1, buying, dp);
        if(buying) {
            int buy = Math.max(cooldown, solve(prices, ind+1, !buying, dp)-prices[ind]);
            dp.put(key, buy);
        } else {
            int sell = Math.max(cooldown, solve(prices, ind+2, !buying, dp)+prices[ind]);
            dp.put(key, sell);
        }
        return dp.get(key);
    }
}
