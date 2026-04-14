class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});

        int stops = 0;

        while(!queue.isEmpty() && stops<=k) {
            stops++;
            for(int i=queue.size()-1; i>=0; i--) {
                int[] curr = queue.poll();
                int node = curr[0], cost = curr[1];

                for(int[] neigh : adj[node]) {
                    int newNode = neigh[0], newCost = neigh[1];
                    if(prices[newNode] > cost + newCost) {
                        prices[newNode] = cost + newCost;
                        queue.offer(new int[]{newNode, prices[newNode]});
                    }
                }
            }
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
