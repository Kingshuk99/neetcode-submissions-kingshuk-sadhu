class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int count = n;

        for(int[] edge :edges) {
            if(union(parent, rank, edge)) {
                count--;
            }
        }

        return count;
    }

    private boolean union(int[] parent, int[] rank, int[] edge) {
        int p1 = find(parent, edge[0]);
        int p2 = find(parent, edge[1]);

        if(p1==p2) {
            return false;
        }

        if(rank[p1]>=rank[p2]) {
            parent[p2] = p1;
            rank[p1]++;
        } else {
            parent[p1] = p2;
            rank[p2]++;
        }

        return true;
    }

    private int find(int[] parent, int node) {
        while(parent[node]!=node) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }

        return node;
    }
}
