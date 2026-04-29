class Solution {
    List<Integer>[] adj;
    int[] indeg;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        indeg = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] prereq : prerequisites) {
            int first = prereq[1], second = prereq[0];
            adj[second].add(first);
            indeg[first]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int finished = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            finished++;
            for(int dependent : adj[course]) {
                indeg[dependent]--;
                if(indeg[dependent] == 0) {
                    queue.offer(dependent);
                }
            }
        }

        return finished == numCourses;
    }
}
