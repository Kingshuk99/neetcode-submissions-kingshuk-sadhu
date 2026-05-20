class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1|| n == 1) {
            return 1;
        }

        if(m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        long ans = 1, j = 1;

        for(int i = m; i < m + n - 1; i++) {
            ans *= i;
            ans /= j;
            j++;
        }

        return (int) ans;
    }
}
