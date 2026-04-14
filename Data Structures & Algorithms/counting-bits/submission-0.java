class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        int offSet = 1;
        for(int i=1; i<=n; i++) {
            if(offSet*2==i) {
                offSet = i;
            }

            ans[i] = 1 + ans[i-offSet];
        }

        return ans;
    }
}
