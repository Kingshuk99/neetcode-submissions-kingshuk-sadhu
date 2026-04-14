class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = n;
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            if(union(edge, parent, rank)) {
                count--;
            }
        }

        return count;
    }

    private boolean union(int[] edge, int[] parent, int[] rank) {
        int p0 = find(edge[0], parent), p1 = find(edge[1], parent);

        if(p0==p1) {
            return false;
        }

        if(rank[p0]>=rank[p1]) {
            parent[p1] = p0;
            rank[p0]++;
        } else {
            parent[p0] = p1;
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
