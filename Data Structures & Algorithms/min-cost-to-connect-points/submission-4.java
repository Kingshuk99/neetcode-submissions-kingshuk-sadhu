class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> 
        (a[0]-b[0]));

        minHeap.offer(new int[]{0, 0});

        int cost = 0;

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currCost = curr[0], ind = curr[1], currX = points[ind][0], 
            currY = points[ind][1];
            if(visited[ind]) {
                continue;
            }
            cost += currCost;
            visited[ind] = true;

            for(int i=0; i<n; i++) {
                if(visited[i]) {
                    continue;
                }
                minHeap.offer(new int[]{Math.abs(points[i][0]-currX) + 
                Math.abs(points[i][1]-currY), i});
            }
        }

        return cost;
    }
}
