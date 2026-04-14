class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] indeg = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] preReq : prerequisites) {
            adj[preReq[1]].add(preReq[0]);
            indeg[preReq[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            if(indeg[i]==0) {
                q.offer(i);
            }
        }

        int counts = 0;
        int[] ans = new int[numCourses];

        while(!q.isEmpty()) {
            int curr = q.poll();
            ans[counts++] = curr;

            for(int neigh : adj[curr]) {
                if(--indeg[neigh]==0) {
                    q.offer(neigh);
                }
            }
        }

        return counts != numCourses ? new int[0] : ans;
    }
}
