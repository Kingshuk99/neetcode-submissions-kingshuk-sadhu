class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, len = 0, maxFreq = 0;
        int[] count = new int[26];

        while(r<s.length()) {
            count[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(r)-'A']);

            while(r-l+1-maxFreq>k) {
                count[s.charAt(l++)-'A']--;
            }

            len = Math.max(len, r-l+1);
            r++;
        }
        return len;
    }
}
