class Solution {
    public String longestPalindrome(String s) {
        int[] answerData = new int[]{0, 0};
        for(int i=0; i<s.length(); i++) {
            checkForPalindrome(s, i, i, answerData);  //odd length
            checkForPalindrome(s, i, i+1, answerData);  //even length
        }
        return s.substring(answerData[0], answerData[0]+answerData[1]);
    }

    private void checkForPalindrome(String s, int l, int r, int[] ans) {
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
            if(r-l+1 > ans[1]) {
                ans[0] = l;
                ans[1] = r-l+1;
            }
            l--;
            r++;
        }
    }
}
