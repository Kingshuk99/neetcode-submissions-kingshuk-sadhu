class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();

        for(int i=0; i<heights.length; i++) {
            dfs(heights, i, 0, heights[i][0], pacific);
            dfs(heights, i, heights[0].length-1, heights[i][heights[0].length-1], 
            atlantic);
        }

        for(int i=0; i<heights[0].length; i++) {
            dfs(heights, 0, i, heights[0][i], pacific);
            dfs(heights, heights.length-1, i, heights[heights.length-1][i], 
            atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<heights.length; i++) {
            for(int j=0; j<heights[0].length; j++) {
                String key = i + "-" + j;
                if(pacific.contains(key) && atlantic.contains(key)) {
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, int r, int c, int prev, Set<String> sea) {
        String key = r + "-" + c;
        if(r<0 || c<0 || r>=heights.length || c>=heights[0].length || 
        sea.contains(key) || heights[r][c]<prev) {
            return;
        }
        sea.add(key);
        dfs(heights, r+1, c, heights[r][c], sea);
        dfs(heights, r-1, c, heights[r][c], sea);
        dfs(heights, r, c+1, heights[r][c], sea);
        dfs(heights, r, c-1, heights[r][c], sea);
    }
}
