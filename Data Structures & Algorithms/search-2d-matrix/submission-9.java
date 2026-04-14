class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m-1, mid = 0;
        while(l<=r) {
            mid = l+(r-l)/2;
            if(matrix[mid][n-1]<target) {
                l = mid+1;
            } else if(matrix[mid][0]>target) {
                r = mid-1;
            } else {
                break;
            }
        }

        if(l>r) {
            return false;
        }

        int row = mid;
        l=0;
        r=n-1;

        while(l<=r) {
            mid = l+(r-l)/2;
            if(matrix[row][mid]==target) {
                return true;
            } else if(matrix[row][mid]>target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return false;
    }
}
