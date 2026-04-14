class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n==1) {
            return cost[0];
        }
        if(n==2) {
            return Math.min(cost[0], cost[1]);
        }

        int a = cost[0], b = cost[1], c = 0;

        for(int i=2; i<=n; i++) {
            int temp = 0;
            if(i<n) {
                temp = cost[i];
            }
            c = Math.min(a, b)+temp;
            a = b;
            b = c;
        }

        return c;
    }
}
