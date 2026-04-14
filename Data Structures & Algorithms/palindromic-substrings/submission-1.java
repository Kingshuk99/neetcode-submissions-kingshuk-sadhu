class Solution {
    private int ans = 0;
    public int countSubstrings(String s) {
        for(int i=0; i<s.length(); i++) {
            //count for odd length
            count(s, i, i);
            //count for even length
            count(s, i, i+1);
        }

        return ans;
    }
    private void count(String s, int l, int r) {
        while(l>=0 && r<s.length() && s.charAt(l--)==s.charAt(r++)) {
            ans++;
        }
    }
}
