class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowZero = false;

        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                if(matrix[r][c] != 0) {
                    continue;
                }

                matrix[0][c] = 0;
                if(r > 0) {
                    matrix[r][0] = 0;
                } else {
                    rowZero = true;
                }
            }
        }

        for(int r = 1; r < matrix.length; r++) {
            for(int c = 1; c < matrix[0].length; c++) {
                if(matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }

        if(rowZero == true) {
            for(int c = 0; c < matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }
    }
}
