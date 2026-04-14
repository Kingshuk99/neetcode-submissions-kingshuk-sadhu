class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        List<int[]>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        int stops = 0;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{src, 0});

        while(!queue.isEmpty() && stops<=k) {
            stops++;
            int len = queue.size();
            for(int i=0; i<len; i++) {
                int[] curr = queue.poll();
                int node = curr[0], cost = curr[1];
                for(int[] neigh : adj[node]) {
                    int neighNode = neigh[0], neighCost = neigh[1];
                    if(prices[neighNode] > cost + neighCost) {
                        prices[neighNode] = cost + neighCost;
                        queue.offer(new int[]{neighNode, prices[neighNode]});
                    }
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
