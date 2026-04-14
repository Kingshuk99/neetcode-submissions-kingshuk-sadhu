class Solution {
    boolean[] vis;
    List<Integer>[] graph;
    public int countComponents(int n, int[][] edges) {
        vis = new boolean[n];
        graph = new ArrayList[n];

        for(int[] edge : edges) {
            if(graph[edge[0]]==null) {
                graph[edge[0]] = new ArrayList<>();
            }
            graph[edge[0]].add(edge[1]);

            if(graph[edge[1]]==null) {
                graph[edge[1]] = new ArrayList<>();
            }
            graph[edge[1]].add(edge[0]);
        }

        int ans = 0;

        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                dfs(i);
                ans++;
            }
        }

        return ans;
    }

    private void dfs(int i) {
        vis[i] = true;

        List<Integer> neighbors = graph[i] != null ? graph[i] : new ArrayList<>();
        for(int node : neighbors) {
            if(!vis[node]) {
                dfs(node);
            }
        }
    }
}
