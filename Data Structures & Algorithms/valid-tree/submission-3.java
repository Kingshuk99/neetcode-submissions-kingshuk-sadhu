class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        boolean[] vis = new boolean[n];

        for(int[] edge : edges) {
            if(adj[edge[0]]==null) {
                adj[edge[0]] = new ArrayList<>();
            }
            adj[edge[0]].add(edge[1]);
            if(adj[edge[1]]==null) {
                adj[edge[1]] = new ArrayList<>();
            }
            adj[edge[1]].add(edge[0]);
        }

        if(isCyclic(adj, vis, 0, -1, n)) {
            return false;
        }

        for(boolean v : vis) {
            if(!v) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclic(List<Integer>[] adj, boolean[] vis, 
    int node, int parent, int n) {
        vis[node] = true;

        List<Integer> neighbors = adj[node];
        if(neighbors==null) {
            return false;
        }

        for(int neighbor : neighbors) {
            if(!vis[neighbor]) {
                if(isCyclic(adj, vis, neighbor, node, n)) {
                    return true;
                }
            }

            else if(neighbor!=parent) {
                return true;
            }
        }

        return false;
    }
}
