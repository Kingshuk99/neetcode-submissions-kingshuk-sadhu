class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    private int dfs(int i, boolean buying, int[] prices) {
        if(i>=prices.length) {
            return 0;
        }

        String key = i+","+buying;

        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int cooldown = dfs(i+1, buying, prices);
        int profit = 0;
        if(buying) {
            profit = dfs(i+1, !buying, prices)-prices[i];
        }
        else {
            profit = dfs(i+2, !buying, prices)+prices[i];
        }

        dp.put(key, Math.max(profit, cooldown));
        return dp.get(key);
    }
}
