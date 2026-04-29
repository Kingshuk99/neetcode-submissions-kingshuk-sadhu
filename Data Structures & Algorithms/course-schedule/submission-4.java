class Solution {
    List<Integer>[] adj;
    boolean[] visited, recStack;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        recStack = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] prereq : prerequisites) {
            int first = prereq[1], second = prereq[0];
            adj[second].add(first);
        }

        for(int course = 0; course < numCourses; course++) {
            if(!dfs(course)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {
        if(recStack[course]) {
            return false;
        }

        if(visited[course]) {
            return true;
        }

        visited[course] = true;
        recStack[course] = true;

        for(int prereq : adj[course]) {
            if(!dfs(prereq)) {
                return false;
            }
        }

        recStack[course] = false;
        return true;
    }
}
