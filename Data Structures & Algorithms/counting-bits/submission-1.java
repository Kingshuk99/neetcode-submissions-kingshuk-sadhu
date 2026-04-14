class Solution {
    public int[] countBits(int n) {
        int offSet = 1;
        int[] ans = new int[n+1];

        for(int i=1; i<=n; i++) {
            if(offSet*2 == i) {
                offSet = i;
            }
            ans[i] = ans[i-offSet] + 1;
        }

        return ans;
    }
}
