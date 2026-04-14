class Solution {
    public double myPow(double x, int n) {
        if(x==0) {
            return 0;
        }
        if(n==0) {
            return 1.0;
        }
        boolean negPow = n<0 ? true:false;
        n = Math.abs(n);
        double ans = 1;

        while(n-->0) {
            ans *= x;
        }

        if(negPow) {
            ans = 1/ans;
        }

        return ans;
    }
}
