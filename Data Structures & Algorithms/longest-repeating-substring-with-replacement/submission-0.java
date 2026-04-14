class Solution {
    public int characterReplacement(String s, int k) {
        int[] dp = new int[26];

        int ans = 0;
        int maxF = 0;
        int l = 0;

        for(int r=0; r<s.length(); r++) {
            dp[s.charAt(r)-'A']++;
            maxF = Math.max(maxF, dp[s.charAt(r)-'A']);

            if(r-l+1-maxF > k) {
                dp[s.charAt(l)-'A']--;
                l++;
            }

            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}
