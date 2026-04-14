class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0]-b[0]));
        minHeap.offer(new int[]{0, 0});
        int totalDist = 0;

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int dist = curr[0], node = curr[1];
            if(vis[node]) {
                continue;
            }
            totalDist += dist;
            vis[node] = true;

            for(int i=0; i<n; i++) {
                if(i==node || vis[i]) {
                    continue;
                }
                int len = Math.abs(points[node][0]-points[i][0]) + 
                Math.abs(points[node][1]-points[i][1]);
                minHeap.offer(new int[]{len, i});
            }
        }
        return totalDist;
    }
}
