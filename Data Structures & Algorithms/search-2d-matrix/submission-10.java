class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int rowLow = 0, rowHigh = ROWS-1, rowMid = 0;
        while(rowLow <= rowHigh) {
            rowMid = rowLow + (rowHigh - rowLow)/2;
            if(matrix[rowMid][COLS-1] < target) {
                rowLow = rowMid + 1;
            } else if(matrix[rowMid][0] > target) {
                rowHigh = rowMid - 1;
            } else {
                break;
            }
        }

        if(rowLow > rowHigh) {
            return false;
        }

        int colLow = 0, colHigh = COLS-1, row = rowMid;
        while(colLow <= colHigh) {
            int colMid = colLow + (colHigh - colLow)/2;
            if(matrix[row][colMid] == target) {
                return true;
            } else if(matrix[row][colMid] < target) {
                colLow = colMid + 1;
            } else {
                colHigh = colMid - 1;
            }
        }
        return false;
    }
}
