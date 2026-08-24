class NumMatrix {
    private int[][] sumMat;
    private int ROWS, COLS;
    public NumMatrix(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;

        this.sumMat = new int[ROWS + 1][COLS + 1];
        for(int r = 0; r < ROWS; r++) {
            int prev = 0;
            for(int c = 0; c < COLS; c++) {
                prev += matrix[r][c];
                sumMat[r + 1][c + 1] = prev + sumMat[r][c + 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;

        return sumMat[row2][col2] - sumMat[row1 - 1][col2] - sumMat[row2][col1 - 1] + sumMat[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */