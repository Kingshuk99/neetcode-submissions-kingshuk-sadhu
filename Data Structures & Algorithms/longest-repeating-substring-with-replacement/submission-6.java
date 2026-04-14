class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];

        int l = 0, maxLen = 0, maxF = 0;
        for(int r=0; r<s.length(); r++) {
            counts[s.charAt(r)-'A']++;
            maxF = Math.max(maxF, counts[s.charAt(r)-'A']);

            if(r-l+1-maxF > k) {
                counts[s.charAt(l++)-'A']--;
            }

            // while(r-l+1-maxF > k) {
            //     counts[s.charAt(l++)-'A']--;
            //     for(int i=0; i<26; i++) {
            //         maxF = Math.max(maxF, counts[i]);
            //     }
            // }

            maxLen = Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }
}
