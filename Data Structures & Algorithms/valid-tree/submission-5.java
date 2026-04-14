class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        if(isCyclic(adj, vis, 0, -1)) {
            return false;
        }
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclic(List<Integer>[] adj, boolean[] vis, int node, 
    int parent) {
        vis[node] = true;
        for(int neigh : adj[node]) {
            if(!vis[neigh]) {
                if(isCyclic(adj, vis, neigh, node)) {
                    return true;
                }
            } else if(neigh != parent) {
                return true;
            }
        }
        return false;
    }
}
