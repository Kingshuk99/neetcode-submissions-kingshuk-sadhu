class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int components = n;

        for(int[] edge : edges) {
            if(union(edge, parent, rank)) {
                components--;
            }
        }
        
        return components;
    }

    private boolean union(int[] edge, int[] parent, int[] rank) {
        int from = edge[0], to = edge[1];
        int fromParent = find(from, parent), toParent = find(to, parent);
        if(fromParent==toParent) {
            return false;
        }

        if(rank[fromParent] >= rank[toParent]) {
            parent[toParent] = fromParent;
            rank[fromParent]++;
        } else {
            parent[fromParent] = toParent;
            rank[toParent]++;
        }
        return true;
    }

    private int find(int node, int[] parent) {
        while(parent[node]!=node) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }
}
