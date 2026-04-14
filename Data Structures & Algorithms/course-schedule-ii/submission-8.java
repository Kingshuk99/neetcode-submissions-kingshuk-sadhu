class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Sol 1
        // boolean[] visited = new boolean[numCourses];
        // boolean[] recStack = new boolean[numCourses];

        // List<Integer>[] adj = new ArrayList[numCourses];
        // for(int i=0; i<numCourses; i++) {
        //     adj[i] = new ArrayList<>();
        // }

        // for(int[] preReq : prerequisites) {
        //     adj[preReq[0]].add(preReq[1]);
        // }

        // List<Integer> res = new ArrayList<>();
        // for(int i=0; i<numCourses; i++) {
        //     if(!dfs(adj, visited, recStack, i, res)) {
        //         return new int[0];
        //     }
        // }

        // int[] ans = new int[res.size()];
        // for(int i=0; i<numCourses; i++) {
        //     ans[i] = res.get(i);
        // }

        // return ans;

        // Sol 2
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] inDeg = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] preReq : prerequisites) {
            adj[preReq[1]].add(preReq[0]);
            inDeg[preReq[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(inDeg[i]==0) {
                queue.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);
            for(int neigh : adj[curr]) {
                inDeg[neigh]--;
                if(inDeg[neigh]==0) {
                    queue.offer(neigh);
                }
            }
        }

        if(res.size() != numCourses) {
            return new int[0];
        }

        int[] ans = new int[res.size()];
        for(int i=0; i<ans.length; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    // private boolean dfs(List<Integer>[] adj, boolean[] visited, 
    // boolean[] recStack, int i, List<Integer> res) {
    //     if(recStack[i]) {
    //         return false;
    //     }
    //     if(visited[i]) {
    //         return true;
    //     }

    //     visited[i] = true;
    //     recStack[i] = true;

    //     for(int ind : adj[i]) {
    //         if(!dfs(adj, visited, recStack, ind, res)) {
    //             return false;
    //         }
    //     }

    //     res.add(i);
    //     recStack[i] = false;
    //     return true;
    // }
}
