class Solution {
    private int len;
    private String ans;
    public String longestPalindrome(String s) {
        len = 0;
        ans = "";

        for(int i=0; i<s.length(); i++) {
            //check for odd len
            checkForPalindrome(s, i, i);
            //check for even len
            checkForPalindrome(s, i, i+1);
        }

        return ans;
    }
    private void checkForPalindrome(String s, int l, int r) {
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
            if(len<r-l+1) {
                len = r-l+1;
                ans = s.substring(l, r+1);
            }
            l--;
            r++;
        }
    }
}
