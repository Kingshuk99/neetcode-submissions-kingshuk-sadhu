class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, node = 0;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] vis = new boolean[n];
        int edges = 0, ans = 0;

        while(edges < n-1) {
            vis[node] = true;
            int next = -1;
            for(int i=0; i<n; i++) {
                if(vis[i]) {
                    continue;
                }

                int currDist = Math.abs(points[node][0]-points[i][0]) + 
                Math.abs(points[node][1]-points[i][1]);

                dist[i] = Math.min(dist[i], currDist);

                if(next == -1 || dist[i] < dist[next]) {
                    next = i;
                }
            }
            ans += dist[next];
            node = next;
            edges++;
        }

        return ans;
    }
}
