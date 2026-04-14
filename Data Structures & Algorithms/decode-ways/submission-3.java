class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') {
            return 0;
        }

        int prev = 1, prePrev = 1, ans = 1;
        for(int i=1; i<s.length(); i++) {
            ans = 0;
            if(s.charAt(i)-'0'>0 && s.charAt(i)-'0'<=9) {
                ans += prev;
            }
            int temp = (s.charAt(i-1)-'0')*10 + s.charAt(i)-'0';
            if(temp>=10 && temp<=26) {
                ans += prePrev;
            }
            prePrev = prev;
            prev = ans;
        }

        return ans;
    }
}
