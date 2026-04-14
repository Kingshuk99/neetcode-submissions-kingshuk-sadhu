class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDeg = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];

        for(int i=0; i<prerequisites.length; i++) {
            int[] relation = prerequisites[i];
            inDeg[relation[0]]++;
            if(graph[relation[1]]==null) {
                graph[relation[1]] = new ArrayList<>();
            }
            graph[relation[1]].add(relation[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            if(inDeg[i]==0) {
                q.add(i);
            }
        }

        int visited = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            visited++;

            for(int i=0; graph[node]!=null && i<graph[node].size(); i++) {
                int nextNode = graph[node].get(i);
                inDeg[nextNode]--;
                if(inDeg[nextNode]==0) {
                    q.add(nextNode);
                }
            }
        }

        return visited==numCourses;
    }
}
