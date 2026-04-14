class Solution {
    public int maxProfit(int[] prices) {
        // return solve(prices, 0, true);


        // int[] buy = new int[prices.length+2];
        // int[] sell = new int[prices.length+2];

        // for(int i=prices.length-1; i>=0; i--) {
        //     buy[i] = Math.max(-prices[i]+sell[i+1], 0+buy[i+1]);
        //     sell[i] = Math.max(prices[i]+buy[i+2], 0+sell[i+1]);
        // }
        // return buy[0];


        int buy1 = 0, buy2 = 0, sell1 = 0;
        for(int i=prices.length-1; i>=0; i--) {
            int buy = Math.max(-prices[i]+sell1, buy1);
            sell1 = Math.max(prices[i]+buy2, sell1);
            buy2 = buy1;
            buy1 = buy;
        }

        return buy1;
    }

    // private int solve(int[] prices, int ind, boolean buy) {
    //     if(ind>=prices.length) {
    //         return 0;
    //     }

    //     if(buy) {
    //         return Math.max(-prices[ind]+solve(prices, ind+1, !buy), 
    //         0+solve(prices, ind+1, buy));
    //     } else {
    //         return Math.max(prices[ind]+solve(prices, ind+2, !buy), 
    //         0+solve(prices, ind+1, buy));
    //     }
    // }
}
