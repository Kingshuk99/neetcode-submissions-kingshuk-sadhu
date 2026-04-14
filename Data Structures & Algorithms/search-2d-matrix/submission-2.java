class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int lr = 0, hr = rows-1, lc = 0, hc = cols-1;
        // System.out.println("here");
        while(lr<=hr) {
            int mr = lr+(hr-lr)/2;
            if(matrix[mr][cols-1]<target) {
                lr = mr+1;
            }
            else if(matrix[mr][0]>target) {
                hr = mr-1;
            }
            else {
                break;
            }
        }

        if(lr>hr) {
            return false;
        }

        int row = lr+(hr-lr)/2;
        // System.out.println("here");

        while(lc<=hc) {
            int mc = lc+(hc-lc)/2;
            if(matrix[row][mc]==target) {
                return true;
            }
            else if(matrix[row][mc]>target) {
                hc = mc-1;
            }
            else {
                lc = mc+1;
            }
        }
        return false;
    }
}
