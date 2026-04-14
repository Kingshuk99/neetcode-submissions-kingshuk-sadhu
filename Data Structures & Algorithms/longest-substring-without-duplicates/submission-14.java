class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int l = 0, maxLen = 0;
        for(int r=0; r<s.length(); r++) {
            if(map.containsKey(s.charAt(r))) {
                // Take max so that if l has already advanced due to any prev char than it should not move back
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }
            map.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
