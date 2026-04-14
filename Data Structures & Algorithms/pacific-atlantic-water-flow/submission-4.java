class Solution {
    private List<List<Integer>> ans;
    private int ROWS, COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<String> pac = new HashSet<>();
        Set<String> atl = new HashSet<>();
        ans = new ArrayList<>();
        ROWS = heights.length;
        COLS = heights[0].length;

        for(int i=0; i<ROWS; i++) {
            dfs(heights, heights[i][0], pac, i, 0);
            dfs(heights, heights[i][COLS-1], atl, i, COLS-1);
        }

        for(int i=0; i<COLS; i++) {
            dfs(heights, heights[0][i], pac, 0, i);
            dfs(heights, heights[ROWS-1][i], atl, ROWS-1, i);
        }

        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                String s = String.valueOf(i)+"-"+String.valueOf(j);
                if(pac.contains(s) && atl.contains(s)) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, int prevHeight, 
    Set<String> vis, int r, int c) {
        String s = String.valueOf(r)+"-"+String.valueOf(c);
        if(r<0 || c<0 || r>=ROWS || c>=COLS || vis.contains(s) || 
        heights[r][c]<prevHeight) {
            return;
        }

        vis.add(s);
        dfs(heights, heights[r][c], vis, r-1, c);
        dfs(heights, heights[r][c], vis, r, c-1);
        dfs(heights, heights[r][c], vis, r+1, c);
        dfs(heights, heights[r][c], vis, r, c+1);
    }
}
