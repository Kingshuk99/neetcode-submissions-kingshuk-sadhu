class DSU {
    private int[] ranks;
    private int[] parents;
    int components;
    public DSU(int n) {
        this.ranks = new int[n];
        this.parents = new int[n];
        this.components = n;
        for(int i = 0; i < n; i++) {
            this.ranks[i] = 1;
            this.parents[i] = i;
        }
    }

    public int find(int node) {
        if(node != parents[node]) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }

    public boolean union(int[] edge) {
        int a = edge[0], b = edge[1];
        int pa = find(a), pb = find(b);

        if(pa == pb) {
            return false;
        }

        if(ranks[pa] >= ranks[pb]) {
            parents[pb] = pa;
            ranks[pa] += ranks[pb];
        } else {
            parents[pa] = pb;
            ranks[pb] += ranks[pa];
        }
        components--;
        return true;
    }

    public int getComponentsCount() {
        return components;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int[] edge : edges) {
            if(!dsu.union(edge)) {
                return false;
            }
        }
        return dsu.getComponentsCount() == 1;
    }
}
