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

        if(isCyclic(adj, visited, 0, -1)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean isCyclic(List<Integer>[] adj, Set<Integer> visited, 
    int node, int parent) {
        visited.add(node);

        for(int neigh : adj[node]) {
            if(!visited.contains(neigh)) {
                if(isCyclic(adj, visited, neigh, node)) {
                    return true;
                }
            } else if(neigh != parent) {
                return true;
            }
        }

        return false;
    }
}
