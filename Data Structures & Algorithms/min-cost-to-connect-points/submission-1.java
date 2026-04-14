class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        Set<Integer> vis = new HashSet<>();
        int cost = 0;

        minHeap.offer(new int[]{0, 0});

        while(vis.size()<points.length) {
            int[] temp = minHeap.poll();
            if(vis.contains(temp[1])) {
                continue;
            }
            cost += temp[0];
            vis.add(temp[1]);
            int[] currEle = points[temp[1]];

            for(int i=0; i<points.length; i++) {
                if(vis.contains(i)) {
                    continue;
                }
                int[] nextEle = points[i];
                int currCost = Math.abs(currEle[0]-nextEle[0])+Math.abs(currEle[1]-nextEle[1]);
                minHeap.offer(new int[]{currCost, i});
            }
        }

        return cost;
    }
}
