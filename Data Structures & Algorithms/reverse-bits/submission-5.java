class Solution {
    public int reverseBits(int n) {
        int ans = 0, shift = 31;
        for(int i = 0; i < 32; i++) {
            ans = (ans | ((n & 1) << shift));
            shift--;
            n = n >> 1;
        }

        return ans;
    }
}
