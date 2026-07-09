class Solution {
    int[] ans;
    int ind;
    boolean[] visited, recStack;
    List<Integer>[] adj;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        recStack = new boolean[numCourses];
        ans = new int[numCourses];
        ind = numCourses - 1;

        for(int course = 0; course < numCourses; course++) {
            adj[course] = new ArrayList<>();
        }

        for(int[] prereq : prerequisites) {
            int first = prereq[1], second = prereq[0];
            adj[first].add(second);
        }

        for(int course = 0; course < numCourses; course++) {
            if(!dfs(course)) {
                return new int[]{};
            }
        }
        return ans;
    }

    private boolean dfs(int course) {
        if(recStack[course] == true) {
            return false;
        }

        if(visited[course] == true) {
            return true;
        }

        recStack[course] = true;
        visited[course] = true;

        for(int prereq : adj[course]) {
            if(!dfs(prereq)) {
                return false;
            }
        }
        recStack[course] = false;
        ans[ind--] = course;
        return true;
    }
}
