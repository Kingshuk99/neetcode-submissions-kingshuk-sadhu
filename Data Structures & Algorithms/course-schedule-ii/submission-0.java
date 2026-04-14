class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDeg = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];

        int[] ans = new int[numCourses];

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<prerequisites.length; i++) {
            int[] relation = prerequisites[i];

            inDeg[relation[0]]++;
            if(graph[relation[1]]==null) {
                graph[relation[1]] = new ArrayList<>();
            }

            graph[relation[1]].add(relation[0]);
        }

        for(int i=0; i<numCourses; i++) {
            if(inDeg[i]==0) {
                q.add(i);
            }
        }

        int vis = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            ans[vis] = node;
            vis++;

            for(int i=0; graph[node]!=null && i<graph[node].size(); i++) {
                int adjNode = graph[node].get(i);
                inDeg[adjNode]--;
                if(inDeg[adjNode]==0) {
                    q.add(adjNode);
                }
            }
        }

        return vis==numCourses?ans:new int[0];
    }
}
