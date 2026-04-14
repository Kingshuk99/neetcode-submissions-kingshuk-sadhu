class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] preReq : prerequisites) {
            adj[preReq[0]].add(preReq[1]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            if(isCyclic(adj, vis, recStack, res, i)) {
                return new int[0];
            }
        }

        int[] ans = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    private boolean isCyclic(List<Integer>[] adj, boolean[] vis, 
    boolean[] recStack, List<Integer> res, int i) {
        if(recStack[i]) {
            return true;
        }

        if(vis[i]) {
            return false;
        }

        vis[i] = true;
        recStack[i] = true;

        for(int neigh : adj[i]) {
            if(isCyclic(adj, vis, recStack, res, neigh)) {
                return true;
            }
        }

        recStack[i] = false;
        res.add(i);
        return false;
    }
}
