class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rm = 0;
        int m = matrix.length, n = matrix[0].length;
        int rl = 0, rh = m-1;

        while(rl <= rh) {
            rm = rl + (rh-rl)/2;
            if(matrix[rm][n-1] < target) {
                rl = rm+1;
            } else if(matrix[rm][0] > target) {
                rh = rm-1;
            } else {
                break;
            }
        }

        if(rl > rh) {
            return false;
        }

        int row = rm;
        int cl = 0, ch = n-1;

        while(cl <= ch) {
            int cm = cl + (ch-cl)/2;
            if(matrix[row][cm] == target) {
                return true;
            } else if(matrix[row][cm] > target) {
                ch = cm-1;
            } else {
                cl = cm+1;
            }
        }
        return false;
    }
}
