class Solution {
    int [] rank;
    int[] par;
    public int[] findRedundantConnection(int[][] edges) {
        rank = new int[edges.length+1];
        par = new int[edges.length+1];

        for(int i=1; i<edges.length; i++) {
            rank[i] = 1;
            par[i] = i;
        }

        for(int[] edge : edges) {
            if(!unite(edge)) {
                return edge;
            }
        }

        return new int[]{-1, -1};
    }

    private boolean unite(int[] edge) {
        int p1 = find(edge[0]);
        int p2 = find(edge[1]);

        if(p1==p2) {
            return false;
        }

        if(rank[p1]>=rank[p2]) {
            par[p2] = p1;
            rank[p1]++;
        }
        else {
            par[p1] = p2;
            rank[p2]++;
        }

        return true;
    }

    private int find(int n) {
        int p = par[n];
        while (p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }
}
