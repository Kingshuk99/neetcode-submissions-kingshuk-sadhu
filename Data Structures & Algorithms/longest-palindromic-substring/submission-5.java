class Solution {
    public String longestPalindrome(String s) {
        int[] p = manacher(s);
        int center = 0, resLen = 0;

        for(int i=0; i<p.length; i++) {
            if(p[i]>resLen) {
                resLen = p[i];
                center = i;
            }
        }

        int start = (center - resLen)/2;
        return s.substring(start, start+resLen);
    }

    private int[] manacher(String s) {
        StringBuilder sb = new StringBuilder("#");
        for(char ch : s.toCharArray()) {
            sb.append(ch).append("#");
        }

        int l = 0, r = 0, n = sb.length();

        int[] p = new int[n];

        for(int i=0; i<n; i++) {
            p[i] = i < r ? Math.min(r-i, p[l+(r-i)]) : 0;
            while(i+p[i]+1<n && i-p[i]-1>=0 && 
            sb.charAt(i-p[i]-1)==sb.charAt(i+p[i]+1)) {
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
