class Solution {
    public double myPow(double x, int n) {
        if(x==0) {
            return 0;
        }
        double res = helper(x, Math.abs((long) n));
        return n>=0 ? res : 1/res;
    }

    private double helper(double x, long n) {
        if(n==0) {
            return 1;
        }

        double res = helper(x*x, n/2);
        if(n%2!=0) {
            res *= x;
        }
        return res;
    }
}
