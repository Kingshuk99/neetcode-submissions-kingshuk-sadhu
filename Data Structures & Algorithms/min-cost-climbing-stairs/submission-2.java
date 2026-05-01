class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1) {
            return 0;
        }

        if(cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int a = 0, b = 0, c = 0;

        for(int i = 2; i <= cost.length; i++) {
            c = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = c;
        }

        return c;
    }
}
