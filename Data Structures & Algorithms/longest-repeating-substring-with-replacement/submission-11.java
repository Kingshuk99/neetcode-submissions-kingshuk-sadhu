class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int l = 0, maxFreq = 0, maxLen = 0;

        for(int r = 0; r < s.length(); r++) {
            counts[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, counts[s.charAt(r) - 'A']);

            if(r - l + 1 - maxFreq > k) {
                counts[s.charAt(l++) - 'A']--;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
