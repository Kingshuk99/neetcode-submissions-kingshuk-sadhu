class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') {
            return 0;
        }
        int prev = 1, prePrev = 1, curr = 1;
        for(int i=1; i<s.length(); i++) {
            curr = 0;
            if(s.charAt(i)-'0'>0 && s.charAt(i)-'0'<=9) {
                curr += prev;
            }
            int temp = (s.charAt(i-1) - '0') * 10 + s.charAt(i) - '0';
            if(temp>=10 && temp<=26) {
                curr += prePrev;
            }
            prePrev = prev;
            prev = curr;
        }
        return curr;
    }
}
