class Solution {
    public int countSubstrings(String s) {
        int[] ans = new int[]{0};

        for(int i=0; i<s.length(); i++) {
            countPalindromes(s, i, i, ans);
            countPalindromes(s, i, i+1, ans);
        }

        return ans[0];
    }

    private void countPalindromes(String s, int l, int r, int[] ans) {
        while(l>=0 && r<s.length() && s.charAt(l--)==s.charAt(r++)) {
            ans[0]++;
        }
    }
}
