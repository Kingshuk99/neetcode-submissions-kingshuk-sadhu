class Solution {
    public int[] countBits(int n) {
        int twoPower = 1;
        int[] ans = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if(i % twoPower == 0) {
                ans[i] = 1;
                twoPower *= 2;
                continue;
            }
            ans[i] = 1 + ans[i % (twoPower / 2)];
        }

        return ans;
    }
}
