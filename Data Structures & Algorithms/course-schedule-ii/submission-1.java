class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] ans = new int[numCourses];
        for( int[] row : prerequisites) {
            if(adj[row[1]]==null) {
                adj[row[1]] = new ArrayList<>();
            }
            adj[row[1]].add(row[0]);
        }

        int[] inDeg = new int[numCourses];

        for(List<Integer> nodes : adj) {
            if(nodes==null) {
                continue;
            }
            for(int node : nodes) {
                inDeg[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            if(inDeg[i]==0) {
                q.offer(i);
            }
        }

        int count = 0;

        while(!q.isEmpty()) {
            int curr = q.poll();

            ans[count++] = curr;
            
            if(adj[curr]==null) {
                continue;
            }
            for(int node : adj[curr]) {
                inDeg[node]--;
                if(inDeg[node]==0) {
                    q.offer(node);
                }
            }
        }

        return count == numCourses ? ans : new int[0];
    }
}
