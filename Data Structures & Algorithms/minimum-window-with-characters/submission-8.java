class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> counts = new HashMap<>();
        int l = 0, MATCHES = 0, start = 0, minLen = s.length() + 1;

        for(int i = 0; i < t.length(); i++) {
            counts.put(t.charAt(i), counts.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if(counts.containsKey(ch)) {
                counts.put(ch, counts.get(ch) - 1);
                if(counts.get(ch) == 0) {
                    MATCHES++;
                }
            }

            while(MATCHES == counts.size()) {
                if(r - l + 1 < minLen) {
                    start = l;
                    minLen = r - l + 1;
                }
                ch = s.charAt(l++);
                if(counts.containsKey(ch)) {
                    counts.put(ch, counts.get(ch) + 1);
                    if(counts.get(ch) == 1) {
                        MATCHES--;
                    }
                }
            }
        }

        return minLen > s.length() ? "" : s.substring(start, start + minLen);
    }
}
