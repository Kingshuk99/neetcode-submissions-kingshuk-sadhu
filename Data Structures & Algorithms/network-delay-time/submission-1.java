class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n+1];

        for(int[] time : times) {
            int u = time[0],  v = time[1],  t = time[2];
            if(adj[u]==null) {
                adj[u] = new ArrayList<>();
            }
            adj[u].add(new int[]{v, t});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0]));
        
        Set<Integer> vis = new HashSet<>();

        int ans = 0;

        minHeap.offer(new int[]{0, k});

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            int t = curr[0], u = curr[1];
            if(vis.contains(u)) {
                continue;
            }
            vis.add(u);
            ans = t;

            List<int[]> neighbors = adj[u];

            if(neighbors==null) {
                continue;
            }

            for(int[] neigh : neighbors) {
                if(vis.contains(neigh[0])) {
                    continue;
                }
                minHeap.offer(new int[]{t+neigh[1], neigh[0]});
            }
        }

        return vis.size()==n ? ans : -1;
    }
}
