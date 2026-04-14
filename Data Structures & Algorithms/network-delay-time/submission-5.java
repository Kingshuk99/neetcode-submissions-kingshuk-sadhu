class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] edge : times) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>())
            .add(new int[]{edge[1], edge[2]});
        }
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
                return time;
            }

            if(!adj.containsKey(node)) {
                continue;
            }

            for(int[] neigh : adj.get(node)) {
                if(vis.contains(neigh[0])) {
                    continue;
                }
                minHeap.offer(new int[]{t + neigh[1], neigh[0]});
            }
        }

        return -1;
    }
}
