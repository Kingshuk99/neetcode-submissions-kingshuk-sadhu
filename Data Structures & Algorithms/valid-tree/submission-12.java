class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        if(!dfs(adj, visited, 0, -1)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs(List<Integer>[] adj, Set<Integer> visited, 
    int node, int parent) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        for (int nei : adj[node]) {
            if (nei == parent) {
                continue;
            }
            if (!dfs(adj, visited, nei, node)) {
                return false;
            }
        }
        return true;
    }
}
