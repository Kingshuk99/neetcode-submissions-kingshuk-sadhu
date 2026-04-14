class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lr = 0, hr = m-1;
        int mid = -1;
        while(lr<=hr) {
            mid = lr+(hr-lr)/2;

            if(matrix[mid][n-1]<target) {
                lr = mid+1;
            }
            else if(matrix[mid][0]>target) {
                hr = mid-1;
            }
            else {
                break;
            }
        }

        if(lr>hr) {
            return false;
        }

        int lc =0, hc = n-1, row = mid;

        while(lc<=hc) {
            mid = lc+(hc-lc)/2;
            if(matrix[row][mid]==target) {
                return true;
            }
            else if(matrix[row][mid]>target) {
                hc = mid-1;
            }
            else {
                lc = mid+1;
            }
        }
        return false;
    }
}
