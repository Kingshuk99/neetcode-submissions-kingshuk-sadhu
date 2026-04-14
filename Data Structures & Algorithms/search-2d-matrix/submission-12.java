class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, row = 0;

        int rl = 0, rh = m-1;

        while(rl <= rh) {
            row = rl + (rh - rl)/2;
            if(matrix[row][n-1] < target) {
                rl = row + 1;
            } else if(matrix[row][0] > target) {
                rh = row - 1;
            } else {
                break;
            }
        }

        if(rl > rh) {
            return false;
        }

        int cl = 0, ch = n-1;

        while(cl <= ch) {
            int col = cl + (ch - cl)/2;
            if(matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                ch = col - 1;
            } else {
                cl = col + 1;
            }
        }

        return false;
    }
}
