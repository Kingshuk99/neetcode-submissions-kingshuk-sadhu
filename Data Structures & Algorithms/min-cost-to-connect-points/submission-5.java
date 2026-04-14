class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0]-b[0]));

        boolean[] vis = new boolean[points.length];

        minHeap.offer(new int[]{0, 0});

        int ans = 0;

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int dist = curr[0], node = curr[1];
            if(vis[node]) {
                continue;
            }
            ans += dist;
            vis[node] = true;
            for(int i=0; i<points.length; i++) {
                if(vis[i]) {
                    continue;
                }
                int[] point = points[i];
                int currDist = Math.abs(point[0]-points[node][0]) + 
                Math.abs(point[1]-points[node][1]);
                minHeap.offer(new int[]{currDist, i});
            }
        }

        return ans;
    }
}
