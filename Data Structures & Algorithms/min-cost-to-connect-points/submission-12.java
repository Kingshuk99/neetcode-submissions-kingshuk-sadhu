class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, node = 0;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int edges = 0, ans = 0;

        while(edges < n - 1) {
            visited[node] = true;
            int nextNode = -1;
            for(int i = 0; i < n; i++) {
                if(visited[i]) {
                    continue;
                }

                int currDist = Math.abs(points[i][0] - points[node][0]) 
                + Math.abs(points[i][1] - points[node][1]);

                dist[i] = Math.min(dist[i], currDist);
                if(nextNode == -1 || dist[i] < dist[nextNode]) {
                    nextNode = i;
                }
            }

            ans += dist[nextNode];
            node = nextNode;
            edges++;
        }

        return ans;
    }
}
