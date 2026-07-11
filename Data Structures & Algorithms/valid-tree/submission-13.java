class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        if(!bfs(adj, visited, 0, -1)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean bfs(List<Integer>[] adj, Set<Integer> visited, int node, 
    int parent) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{node, parent});
        visited.add(node);

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currNode = curr[0], currParen = curr[1];

            for(int nei : adj[currNode]) {
                if(nei == currParen) {
                    continue;
                }
                if(visited.contains(nei)) {
                    return false;
                }
                visited.add(nei);
                queue.offer(new int[]{nei, currNode});
            }
        }
        return true;
    }
}
