class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] preReq : prerequisites) {
            adj[preReq[0]].add(preReq[1]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!vis[i] && isCyclic(adj, vis, recStack, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclic(List<Integer>[] adj, boolean[] vis, boolean[] recStack, int i) {
        vis[i] = true;
        recStack[i] = true;

        for(int neigh : adj[i]) {
            if(!vis[neigh] && isCyclic(adj, vis, recStack, neigh)) {
                return true;
            } else if(recStack[neigh]) {
                return true;
            }
        }

        recStack[i] = false;
        return false;
    }
}
