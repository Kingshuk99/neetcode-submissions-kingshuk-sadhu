class Solution {
    public int maxProfit(int[] prices) {
        // return solve(prices, 0, false);

        // int[] has = new int[prices.length + 2];
        // int[] notHas = new int[prices.length + 2];

        int currHave = 0, prevHave = 0, currNotHave = 0;
        int prevNotHave = 0, prevToPrevNotHave = 0;

        for(int i = prices.length - 1; i >= 0; i--) {
            currNotHave = Math.max(prevNotHave, prevHave - prices[i]);
            currHave = Math.max(prevToPrevNotHave + prices[i], prevHave);

            prevHave = currHave;
            prevToPrevNotHave = prevNotHave;
            prevNotHave = currNotHave;
        }

        return currNotHave;
    }

    // private int solve(int[] prices, int i, boolean has) {
    //     if(i >= prices.length) {
    //         return 0;
    //     }

    //     if(has == false) {
    //         return Math.max(solve(prices, i + 1, has), 
    //         solve(prices, i + 1, !has) - prices[i]);
    //     }
    //     return Math.max(prices[i] + solve(prices, i + 2, !has), 
    //     solve(prices, i + 1, has));
    // }
}
