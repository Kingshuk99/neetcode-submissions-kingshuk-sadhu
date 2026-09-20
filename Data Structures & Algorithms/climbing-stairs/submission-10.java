class Solution {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }

        int[][] M = {{1, 1}, {1, 0}};
        int[][] res = matrixPow(M, n);
        return res[0][0];
    }

    private int[][] matrixPow(int[][] M, int p) {
        int[][] result = {{1, 0}, {0, 1}};
        int[][] base = M;

        while(p > 0) {
            if(p % 2 == 1) {
                result = matrixMult(result, base);
            }
            base = matrixMult(base, base);
            p /= 2;
        }

        return result;
    }

    private int[][] matrixMult(int[][] A, int[][] B) {
        return new int[][] {
            {A[0][0] * B[0][0] + A[0][1] * B[1][0],
            A[0][0] * B[0][1] + A[0][1] * B[1][1]},
            {A[1][0] * B[0][0] + A[1][1] * B[1][0],
            A[1][0] * B[0][1] + A[1][1] * B[1][1]}
        };
    }
}
