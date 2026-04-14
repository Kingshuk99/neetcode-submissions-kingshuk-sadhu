class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1) {
            return 0;
        }
        if(cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int a = cost[0], b = cost[1], c = 0;
        for(int i=2; i<=cost.length; i++) {
            int temp = 0;
            if(i < cost.length) {
                temp = cost[i];
            }
            c = Math.min(a, b) + temp;
            a = b;
            b = c;
        }
        return c;
    }
}
