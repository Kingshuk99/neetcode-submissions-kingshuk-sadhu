class Solution {
    List<Integer>[] adj;
    boolean[] visited, recStack;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        recStack = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] prereq : prerequisites) {
            int first = prereq[0], second = prereq[1];
            adj[second].add(first);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(adj, visited, recStack, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<Integer>[] adj, boolean[] visited, 
    boolean[] recStack, int node) {
        if(recStack[node]) {
            return false;
        }

        if(visited[node]) {
            return true;
        }

        recStack[node] = true;
        visited[node] = true;

        for(int neigh : adj[node]) {
            if(!dfs(adj, visited, recStack, neigh)) {
                return false;
            }
        }
        recStack[node] = false;
        return true;
    }
}
