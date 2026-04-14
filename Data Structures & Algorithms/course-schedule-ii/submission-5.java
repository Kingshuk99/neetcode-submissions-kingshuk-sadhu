class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] preReq : prerequisites) {
            adj[preReq[0]].add(preReq[1]);
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            if(!dfs(adj, visited, recStack, i, res)) {
                return new int[0];
            }
        }

        int[] ans = new int[res.size()];
        for(int i=0; i<numCourses; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    private boolean dfs(List<Integer>[] adj, boolean[] visited, 
    boolean[] recStack, int i, List<Integer> res) {
        if(recStack[i]) {
            return false;
        }
        if(visited[i]) {
            return true;
        }

        visited[i] = true;
        recStack[i] = true;

        for(int ind : adj[i]) {
            if(!dfs(adj, visited, recStack, ind, res)) {
                return false;
            }
        }

        res.add(i);
        recStack[i] = false;
        return true;
    }
}
