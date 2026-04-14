class Solution {
    public void rotate(int[][] matrix) {
        int l = 0, r = matrix.length-1;
        while(l<r) {
            for(int i=0; i<r-l; i++) {
                int topLeft = matrix[l][l+i];
                matrix[l][l+i] = matrix[r-i][l];  //top left
                matrix[r-i][l] = matrix[r][r-i];  //bottom left
                matrix[r][r-i] = matrix[l+i][r];  //bottom right
                matrix[l+i][r] = topLeft;       ////top right
            }
            l++;
            r--;
        }
    }
}
