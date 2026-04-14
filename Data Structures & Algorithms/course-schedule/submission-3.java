class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] preReq : prerequisites) {
            adj[preReq[0]].add(preReq[1]);
        }

        
        for(int i=0; i<numCourses; i++) {
            if(!dfs(adj, visited, recStack, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<Integer>[] adj, boolean[] visited, 
    boolean[] recStack, int i) {
        if(recStack[i]) {
            return false;
        }
        if(visited[i]) {
            return true;
        }

        visited[i] = true;
        recStack[i] = true;

        for(int ind : adj[i]) {
            if(!dfs(adj, visited, recStack, ind)) {
                return false;
            }
        }

        recStack[i] = false;
        return true;
    }
}
