class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = createGraph(times, n);
        Set<Integer> vis = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0]-b[0]));
        minHeap.offer(new int[]{0, k});
        int time = 0;
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int t = curr[0], node = curr[1];
            if(vis.contains(node)) {
                continue;
            }
            time = t;
            vis.add(node);
            if(vis.size()==n) {
                break;
            }

            for(int[] edge : adj.get(node)) {
                if(vis.contains(edge[0])) {
                    continue;
                }
                minHeap.offer(new int[]{t+edge[1], edge[0]});
            }
        }
        return vis.size() == n ? time : -1;
    }

    private Map<Integer, List<int[]>> createGraph(int[][] times, int n) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i=1; i<=n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] time : times) {
            int u = time[0], v = time[1], t = time[2];
            adj.get(u).add(new int[]{v, t});
        }

        return adj;
    }
}
