class Solution {
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2, psi = (1 - sqrt5) / 2;
        n++;

        return (int) Math.round((Math.pow(phi, n) - Math.pow(psi, n)) / sqrt5);
    }
}
