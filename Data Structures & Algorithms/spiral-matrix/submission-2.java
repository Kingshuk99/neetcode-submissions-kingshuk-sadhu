class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length-1, n=matrix[0].length-1;
        int r=0, c=0;
        List<Integer> ans = new ArrayList<>();
        while(r<=m && c<=n) {
            for(int i=c; i<=n; i++) {
                ans.add(matrix[r][i]);
            }
            r++;
            for(int i=r; i<=m; i++) {
                ans.add(matrix[i][n]);
            }
            n--;
            if(r<=m) {
                for(int i=n; i>=c; i--) {
                    ans.add(matrix[m][i]);
                }
                m--;
            }
            if(c<=n) {
                for(int i=m; i>=r; i--) {
                    ans.add(matrix[i][c]);
                }
                c++;
            }
        }

        return ans;
    }
}
