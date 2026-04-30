class DSU {
    int[] parents, ranks;

    DSU(int n) {
        parents = new int[n];
        ranks = new int[n];

        for(int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    int find(int node) {
        if(node != parents[node]) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }

    boolean union(int node1, int node2) {
        int parent1 = find(node1), parent2 = find(node2);

        if(parent1 == parent2) {
            return false;
        }

        if(ranks[parent1] >= ranks[parent2]) {
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        } else {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        }
        return true;
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        int ans = n;
        DSU dsu = new DSU(n);

        for(int[] edge : edges) {
            if(dsu.union(edge[0], edge[1])) {
                ans--;
            }
        }

        return ans;
    }
}
