class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, ans = 0, maxF = 0;
        int[] counts = new int[26];
        for(int r=0; r<s.length(); r++) {
            counts[s.charAt(r)-'A']++;
            maxF = Math.max(maxF, counts[s.charAt(r)-'A']);

            if(r-l+1-maxF > k) {
                counts[s.charAt(l++)-'A']--;
            }

            ans = Math.max(ans, r-l+1);
        }

        return ans;
    }
}
