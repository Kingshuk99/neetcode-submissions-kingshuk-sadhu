class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        if(isCyclic(adj, visited, 0, -1)) {
            return false;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclic(List<Integer>[] adj, boolean[] visited, 
    int node, int parent) {
        visited[node] = true;
        for(int neigh : adj[node]) {
            if(!visited[neigh]) {
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
