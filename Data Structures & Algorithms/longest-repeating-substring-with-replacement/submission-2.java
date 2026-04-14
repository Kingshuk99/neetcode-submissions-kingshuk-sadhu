class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;
        int[] counts = new int[26];

        while(r < s.length()) {
            counts[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq, counts[s.charAt(r)-'A']);
            if(r-l+1-maxFreq > k) {
                counts[s.charAt(l++)-'A']--;
            }
            maxLen = Math.max(r-l+1, maxLen);
            r++;
        }
        return maxLen;
    }
}
