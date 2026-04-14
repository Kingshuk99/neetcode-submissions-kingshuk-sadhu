class Solution {
    List<Integer>[] graph;
    boolean[] visited;

    public boolean validTree(int n, int[][] edges) {
        graph = new ArrayList[n];
        visited = new boolean[n];

        for(int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            if(graph[edge[0]]==null) {
                graph[edge[0]] = new ArrayList<>();
            }
            graph[edge[0]].add(edge[1]);
            if(graph[edge[1]]==null) {
                graph[edge[1]] = new ArrayList<>();
            }
            graph[edge[1]].add(edge[0]);
        }


        if(isCyclic(0, -1, n)) {
            return false;
        }

        for(boolean vis : visited) {
            if(!vis) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclic(int node, int parent, int n) {
        visited[node] = true;

        List<Integer> neighbors = graph[node];
        if(neighbors==null) {
            return false;
        }
        for(int neighbor : neighbors) {
            if(!visited[neighbor]) {
                if(isCyclic(neighbor, node, n)) {
                return true;
                }
            }

            else if(neighbor != parent) {
                return true;
            }
        }

        return false;
    }
}
