class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0, l = 0, maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int r=0; r<s.length(); r++) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            if(r-l+1-maxFreq > k) {
                ch = s.charAt(l++);
                map.put(ch, map.get(ch)-1);
            }

            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}
