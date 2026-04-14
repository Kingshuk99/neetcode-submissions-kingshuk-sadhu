class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<heights.length; i++) {
            dfs(heights, pacific, i, 0, dirs, heights[i][0]);
            dfs(heights, atlantic, i, heights[0].length-1, dirs, 
            heights[i][heights[0].length-1]);
        }

        for(int i=0; i<heights[0].length; i++) {
            dfs(heights, pacific, 0, i, dirs, heights[0][i]);
            dfs(heights, atlantic, heights.length-1, i, dirs, 
            heights[heights.length-1][i]);
        }

        for(int i=0; i<heights.length; i++) {
            for(int j=0; j<heights[0].length; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, boolean[][] sea, int i, int j, 
    int[][] dirs, int prev) {
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length || 
        heights[i][j]<prev || sea[i][j]) {
            return;
        }

        sea[i][j] = true;
        for(int[] dir : dirs) {
            dfs(heights, sea, i+dir[0], j+dir[1], dirs, heights[i][j]);
        }
    }
}
