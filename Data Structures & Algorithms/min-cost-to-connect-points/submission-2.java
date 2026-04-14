class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Set<Integer> vis = new HashSet<>();
        minHeap.offer(new int[]{0, 0});
        int cost = 0;

        while(points.length>vis.size()) {
            int[] currInd = minHeap.poll();
            if(vis.contains(currInd[1])) {
                continue;
            }
            vis.add(currInd[1]);
            cost += currInd[0];
            int[] curr = points[currInd[1]];

            for(int i=0; i<points.length; i++) {
                if(vis.contains(i)) {
                    continue;
                }

                int[] neigh = points[i];

                int newCost = Math.abs(neigh[0]-curr[0])+Math.abs(neigh[1]-curr[1]);
                minHeap.offer(new int[]{newCost, i});
            }
        }

        return cost;
    }
}
