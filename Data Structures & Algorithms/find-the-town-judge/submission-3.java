class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] delta = new int[n + 1];

        for(int[] tr : trust) {
            delta[tr[0]]--;
            delta[tr[1]]++;
        }

        for(int i = 1; i <= n; i++) {
            if(delta[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}