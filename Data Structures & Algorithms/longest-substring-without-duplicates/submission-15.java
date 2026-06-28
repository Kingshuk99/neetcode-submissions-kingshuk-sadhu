class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, maxLen = 0;
        Map<Character, Integer> indexes = new HashMap<>();

        for(int r = 0; r < s.length(); r++) {
            if(indexes.containsKey(s.charAt(r))) {
                l = Math.max(l, indexes.get(s.charAt(r)) + 1);
            }
            indexes.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
