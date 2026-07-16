class Solution {
    public int countSubstrings(String s) {
        int[] manacher = getManacherArr(s);
        int counts = 0;

        for(int len : manacher) {
            counts += (len + 1) / 2;
        }

        return counts;
    }

    private int[] getManacherArr(String s) {
        StringBuilder sb = new StringBuilder("#");
        for(char ch : s.toCharArray()) {
            sb.append(ch).append("#");
        }
        int n = sb.length();
        int l = 0, r = 0;
        int[] manacher = new int[n];

        for(int i = 0; i < n; i++) {
            manacher[i] = i < r ? Math.min(r - i, manacher[l + (r - i)]) : 0;

            while(i + manacher[i] + 1 < n && i - manacher[i] - 1 >= 0 &&
            sb.charAt(i + manacher[i] + 1) == sb.charAt(i - manacher[i] - 1)) {
                manacher[i]++;
            }

            if(r < i + manacher[i]) {
                l = i - manacher[i];
                r = i + manacher[i];
            }
        }

        return manacher;
    }
}
