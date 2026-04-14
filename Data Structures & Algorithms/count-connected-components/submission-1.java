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
            if(union(rank, parent, edge)) {
                count--;
            }
        }

        return count;
    }

    private boolean union(int[] rank, int[] parent, int[] edge) {
        int p1 = find(edge[0], parent);
        int p2 = find(edge[1], parent);

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
