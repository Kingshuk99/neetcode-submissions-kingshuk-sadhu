class Solution {
    public String longestPalindrome(String s) {
        //Manacher's Algorithm
        int[] p = manacher(s);
        int resLen = 0, center = 0;
        for(int i=0; i<p.length; i++) {
            if(p[i]>resLen) {
                resLen = p[i];
                center = i;
            }
        }
        int resInd = (center - resLen) / 2;
        return s.substring(resInd, resInd + resLen);
    }

    private int[] manacher(String s) {
        StringBuilder sb = new StringBuilder("#");
        for(char ch : s.toCharArray()) {
            sb.append(ch).append("#");
        }
        int n = sb.length();
        int[] p = new int[n];
        int l = 0, r = 0;

        for(int i=0; i<n; i++) {
            p[i] = i < r ? Math.min(r-i, p[l+(r-i)]) : 0;
            while(i+p[i]+1 < n && i-p[i]-1 >= 0 && 
            sb.charAt(i+p[i]+1) == sb.charAt(i-p[i]-1)) {
                p[i]++;
            }
            if(i+p[i] > r) {
                l = i-p[i];
                r = i+p[i];
            }
        }
        return p;
    }
}
