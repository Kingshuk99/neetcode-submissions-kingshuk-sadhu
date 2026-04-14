class Solution {
    public int maxProfit(int[] prices) {
        return calculateProfit(prices, 0, true);
    }

    private int calculateProfit(int[] prices, int ind, boolean buying) {
        if(ind >= prices.length) {
            return 0;
        }

        int profit = calculateProfit(prices, ind+1, buying);
        if(buying) {
            profit = Math.max(profit, 
            calculateProfit(prices, ind+1, !buying)-prices[ind]);
        } else {
            profit = Math.max(profit, 
            calculateProfit(prices, ind+2, !buying)+prices[ind]);
        }

        return profit;
    }
}
