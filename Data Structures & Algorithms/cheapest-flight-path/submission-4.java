class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;

        for(int step=0; step<=k; step++) {
            int[] newCosts = Arrays.copyOfRange(costs, 0, n);
            for(int[] flight : flights) {
                int s = flight[0], d = flight[1], cost = flight[2];
                if(costs[s]==Integer.MAX_VALUE) {
                    continue;
                }
                if(newCosts[d]>costs[s]+cost) {
                    newCosts[d] = costs[s]+cost;
                }
            }
            costs = newCosts;
        }
        return costs[dst] != Integer.MAX_VALUE ? costs[dst] : -1;
    }
}
