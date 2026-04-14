class Solution {
    class DSU {
        int[] parents;
        int[] ranks;
        int components;

        DSU(int n) {
            this.parents = new int[n];
            this.ranks = new int[n];
            this.components = n;
            for(int i=0; i<n; i++) {
                this.parents[i] = i;
                this.ranks[i] = 1;
            }
        }

        int find(int node) {
            while(parents[node]!=node) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }

        boolean union(int u, int v) {
            int parentU = find(u), parentV = find(v);
            if(parentU == parentV) {
                return false;
            }

            if(ranks[parentU] >= ranks[parentV]) {
                parents[parentV] = parentU;
                ranks[parentU]++;
            } else {
                parents[parentU] = parentV;
                ranks[parentV]++;
            }
            components--;
            return true;
        }

        int getComponents() {
            return components;
        }

    }
    public boolean validTree(int n, int[][] edges) {
        // Find cycle using dfs
        // List<Integer>[] adj = new ArrayList[n];
        // boolean[] visited = new boolean[n];
        // for(int i=0; i<n; i++) {
        //     adj[i] = new ArrayList<>();
        // }

        // for(int[] edge : edges) {
        //     adj[edge[0]].add(edge[1]);
        //     adj[edge[1]].add(edge[0]);
        // }

        // if(isCyclic(adj, visited, 0, -1)) {
        //     return false;
        // }

        // for(int i=0; i<n; i++) {
        //     if(!visited[i]) {
        //         return false;
        //     }
        // }

        // return true;

        // Find cycle using DSU
        DSU dsu = new DSU(n);
        for(int[] edge : edges) {
            if(!dsu.union(edge[0], edge[1])) {
                return false;
            }
        }
        return dsu.getComponents() == 1;
    }

    // private boolean isCyclic(List<Integer>[] adj, boolean[] visited, 
    // int node, int parent) {
    //     visited[node] = true;
    //     for(int neigh : adj[node]) {
    //         if(!visited[neigh]) {
    //             if(isCyclic(adj, visited, neigh, node)) {
    //                 return true;
    //             }
    //         } else if(neigh != parent) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}
