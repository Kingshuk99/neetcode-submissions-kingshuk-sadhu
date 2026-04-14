class Solution {
    public String longestPalindrome(String s) {
        int[] p = manachers(s);
        int len = 0, center = 0;

        for(int i=0; i<p.length; i++) {
            if(len<p[i]) {
                center = i;
                len = p[i];
            }
        }
        int start = (center - len)/2;
        return s.substring(start, start + len);
    }

    private int[] manachers(String s) {
        StringBuilder sb = new StringBuilder("#");
        for(char ch : s.toCharArray()) {
            sb.append(ch).append('#');
        }

        int n = sb.length(), l = 0, r = 0;
        int[] p = new int[n];

        for(int i=0; i<n; i++) {
            p[i] = i < r ? Math.min(r-i, p[l+(r-i)]) : 0;

            while(i+p[i]+1<n && i-p[i]-1>=0 && 
            sb.charAt(i+p[i]+1)==sb.charAt(i-p[i]-1)) {
                p[i]++;
            }
            if(i+p[i]>r) {
                l = i-p[i];
                r = i+p[i];
            }
        }
        return p;
    }
}
