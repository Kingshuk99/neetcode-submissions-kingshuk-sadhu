class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=0; i<=n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            if(!union(edge, parent, rank)) {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean union(int[] edge, int[] parent, int[] rank) {
        int p1 = find(edge[0], parent), p2 = find(edge[1], parent);

        if(p1==p2) {
            return false;
        }

        if(rank[p1]<rank[p2]) {
            parent[p1] = p2;
            rank[p2]++;
        } else {
            parent[p2] = p1;
            rank[p1]++;
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
