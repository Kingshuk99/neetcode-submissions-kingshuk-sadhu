class Solution {
    int[] ans, indeg;
    int ind;
    List<Integer>[] adj;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        ans = new int[numCourses];
        indeg = new int[numCourses];
        ind = 0;

        for(int course = 0; course < numCourses; course++) {
            adj[course] = new ArrayList<>();
        }

        for(int[] prereq : prerequisites) {
            int first = prereq[1], second = prereq[0];
            adj[first].add(second);
            indeg[second]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int course =  queue.poll();
            ans[ind++] = course;
            for(int dependent : adj[course]) {
                indeg[dependent]--;
                if(indeg[dependent] == 0) {
                    queue.offer(dependent);
                }
            }
        }

        return ind == numCourses ? ans : new int[]{};
    }
}
