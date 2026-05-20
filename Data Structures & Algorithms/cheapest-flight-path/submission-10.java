class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        List<int[]>[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] flight : flights) {
            int start = flight[0], end = flight[1], cost = flight[2];
            adj[start].add(new int[]{end, cost});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, src, 0});

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cost = curr[0], start = curr[1], stops = curr[2];
            if(stops > k) {
                break;
            }

            for(int[] neighbour : adj[start]) {
                int neigh = neighbour[0], weight = neighbour[1];
                int newCost = cost + weight;

                if(newCost < prices[neigh]) {
                    prices[neigh] = newCost;
                    queue.offer(new int[]{newCost, neigh, stops + 1});
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
