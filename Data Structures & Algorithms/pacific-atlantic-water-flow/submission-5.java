class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();
        int m = heights.length, n = heights[0].length;

        for(int i=0; i<m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0], m, n);
            dfs(heights, atlantic, i, n-1, heights[i][n-1], m, n);
        }

        for(int i=0; i<n; i++) {
            dfs(heights, pacific, 0, i, heights[0][i], m, n);
            dfs(heights, atlantic, m-1, i, heights[m-1][i], m, n);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                String s = i + "-" + j;
                if(pacific.contains(s) && atlantic.contains(s)) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, Set<String> sea, int i, int j, 
    int prevHeight, int m, int n) {
        String s = i + "-" + j;
        if(i<0 || j<0 || i>=m || j>=n || heights[i][j]<prevHeight || 
        sea.contains(s)) {
            return;
        }
        sea.add(s);
        dfs(heights, sea, i, j-1, heights[i][j], m, n);
        dfs(heights, sea, i-1, j, heights[i][j], m, n);
        dfs(heights, sea, i, j+1, heights[i][j], m, n);
        dfs(heights, sea, i+1, j, heights[i][j], m, n);
    }
}
