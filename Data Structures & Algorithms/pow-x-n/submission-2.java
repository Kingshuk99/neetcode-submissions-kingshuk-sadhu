class Solution {
    public double myPow(double x, int n) {
        if(n>=0) {
            return solve(x, n);
        }
        return 1/solve(x, -n);
    }
    private double solve(double x, int n) {
        if(n==0) {
            return (double)1;
        }
        double temp = solve(x, n/2);
        if(n%2==0) {
            return temp*temp;
        } else {
            return temp*temp*x;
        }
    }
}
