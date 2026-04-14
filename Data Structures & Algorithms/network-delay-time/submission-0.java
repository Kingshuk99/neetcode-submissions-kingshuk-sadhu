class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n+1];

        for(int[] edge : times) {
            int u = edge[0], v = edge[1], t = edge[2];
            if(adj[u]==null) {
                adj[u] = new ArrayList<>();
            }
            adj[u].add(new int[]{v, t});
        }

        int time = 0;
        Set<Integer> vis = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, k});
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if(vis.contains(curr[1])) {
                continue;
            }
            time = curr[0];
            vis.add(curr[1]);
            List<int[]> neighbors = adj[curr[1]]!=null ? adj[curr[1]] : new ArrayList<>();
            for(int[] edge : neighbors) {
                if(vis.contains(edge[0])) {
                    continue;
                }
                minHeap.offer(new int[]{time+edge[1], edge[0]});
            }
        }

        return vis.size() == n ? time : -1; 
    }
}
