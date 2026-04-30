class DSU {
    int[] parents, ranks;
    int components;
    public DSU(int n) {
        components = n;
        parents = new int[n];
        ranks = new int[n];

        for(int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public int find(int node) {
        if(node != parents[node]) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }

    public boolean union(int node1, int node2) {
        int parent1 = find(node1), parent2 = find(node2);

        if(parent1 == parent2) {
            return false;
        }

        components--;
        if(ranks[parent1] >= ranks[parent2]) {
            parents[parent2] = parent1;
            ranks[parent1]++;
        } else {
            parents[parent2] = parent1;
            ranks[parent1]++;
        }
        return true;
    }

    public int getComponents() {
        return components;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1) {
            return false;
        }

        DSU dsu = new DSU(n);

        for(int[] edge : edges) {
            if(!dsu.union(edge[0], edge[1])) {
                return false;
            }
        }

        return dsu.getComponents() == 1;
    }
}
