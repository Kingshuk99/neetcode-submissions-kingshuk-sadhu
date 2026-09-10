class Solution {
    public int mySqrt(int x) {
        int l = 1, r = x, ans = 0;
        
        while(l <= r) {
            int m = l + (r - l) / 2;
            long sqr = (long)m * (long)m;
            long num = (long) x;
            if(sqr == num) {
                return m;
            } else if(sqr < num) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}