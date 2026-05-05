class Solution {
    public String longestPalindrome(String s) {
        int[] manacher = manacherArr(s);
        int resLen = 0, center = 0;
        for(int i = 0; i < manacher.length; i++) {
            if(manacher[i] > resLen) {
                resLen = manacher[i];
                center = i;
            }
        }
        int resIdx = (center - resLen) / 2;
        return s.substring(resIdx, resIdx + resLen);
    }

    private int[] manacherArr(String s) {
        StringBuilder sb = new StringBuilder("#");
        for(char ch : s.toCharArray()) {
            sb.append(ch).append("#");
        }

        int n = sb.length();
        int[] manacher = new int[n];
        int l = 0, r = 0;

        for(int i = 0; i < n; i++) {
            manacher[i] = i < r ? Math.min(r - i, manacher[l + (r - i)]) : 0;
            while(i + manacher[i] + 1 < n && i - manacher[i] - 1 >= 0 && 
            sb.charAt(i + manacher[i] + 1) == sb.charAt(i - manacher[i] - 1)) {
                manacher[i]++;
            }
            if(i + manacher[i] > r) {
                l = i - manacher[i];
                r = i + manacher[i];
            }
        }
        return manacher;
    }
}
