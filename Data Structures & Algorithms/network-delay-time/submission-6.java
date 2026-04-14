class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0]-b[0]));
        List<int[]>[] adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] time : times) {
            adj[time[0]].add(new int[]{time[1], time[2]});
        }

        Set<Integer> vis = new HashSet<>();
        minHeap.offer(new int[]{0, k});
        int time = 0;

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if(vis.contains(curr[1])) {
                continue;
            }
            time = curr[0];
            vis.add(curr[1]);
            if(vis.size()==n) {
                return time;
            }

            for(int[] node : adj[curr[1]]) {
                if(vis.contains(node[0])) {
                    continue;
                }
                minHeap.offer(new int[]{node[1]+curr[0], node[0]});
            }
        }
        return -1;
    }
}
