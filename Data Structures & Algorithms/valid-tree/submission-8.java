class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1){
            return false;
        }

        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        Set<Integer> visited = new HashSet<>();

        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        if(isCyclic(adj, visited, 0, -1)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean isCyclic(List<Integer>[] adj, 
    Set<Integer> visited, int node, int parent) {
        visited.add(node);

        for(int neighbour : adj[node]) {
            if(!visited.contains(neighbour)) {
                if(isCyclic(adj, visited, neighbour, node)) {
                    return true;
                }
            } else if(neighbour != parent) {
                return true;
            }
        }

        return false;
    }
}
