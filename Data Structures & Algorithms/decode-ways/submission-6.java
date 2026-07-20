class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }

        int prev = 1, prePrev = 1, ways = 1;

        for(int i = 1; i < s.length(); i++) {
            ways = 0;
            if(s.charAt(i) > '0' && s.charAt(i) <= '9') {
                ways += prev;
            }

            int lastTwo = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if(lastTwo >= 10 && lastTwo <= 26) {
                ways += prePrev;
            }
            prePrev = prev;
            prev = ways;
        }
        return ways;
    }
}
