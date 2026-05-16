class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] time : times) {
            adj.computeIfAbsent(time[0], key -> new ArrayList<>())
            .add(new int[]{time[1], time[2]});
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> (a[0] - b[0]));

        minHeap.offer(new int[]{0, k});
        int time = 0;

        while(!minHeap.isEmpty()) {
            int[] edge = minHeap.poll();
            int weight = edge[0], node = edge[1];
            if(visited.contains(node)) {
                continue;
            }

            visited.add(node);

            time = weight;

            if(!adj.containsKey(node)) {
                continue;
            }

            for(int[] next : adj.get(node)) {
                int nextNode = next[0], nextWeight = next[1];
                if(!visited.contains(nextNode)) {
                    minHeap.offer(new int[]{weight + nextWeight, 
                    nextNode});
                }
            }
        }

        return visited.size() == n ? time : -1;
    }
}
