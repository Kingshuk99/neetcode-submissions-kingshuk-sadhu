class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, len = 0, maxFreq = 0;
        int[] counts = new int[26];

        for(int r=0; r<s.length(); r++) {
            counts[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq, counts[s.charAt(r)-'A']);

            if(r-l+1-maxFreq > k) {
                counts[s.charAt(l++)-'A']--;
            }

            len = Math.max(len, r-l+1);
        }

        return len;
    }
}
