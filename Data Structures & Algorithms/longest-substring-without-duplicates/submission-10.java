class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, maxLen = 0;
        Set<Character> exists = new HashSet<>();
        while(r<s.length()) {
            while(exists.contains(s.charAt(r))) {
                exists.remove(s.charAt(l++));
            }
            exists.add(s.charAt(r));
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}
