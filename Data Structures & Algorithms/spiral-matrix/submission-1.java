class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int r = 0, c = 0;

        List<Integer> ans = new ArrayList<>();

        while(r < m && c < n) {
            for(int j=c; j<n; j++) {
                ans.add(matrix[r][j]);
            }
            r++;
            for(int i=r; i<m; i++) {
                ans.add(matrix[i][n-1]);
            }
            n--;
            if(r<m) {
                for(int j=n-1; j>=c; j--) {
                    ans.add(matrix[m-1][j]);
                }
            }
            m--;
            if(c<n) {
                for(int i=m-1; i>=r; i--) {
                    ans.add(matrix[i][c]);
                }
            }
            c++;
        }
        return ans;
    }
}
