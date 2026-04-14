class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> counts = new HashMap<>();
        int len = s.length() + 1, start = 0;

        for(char ch : t.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        int MATCHES = 0, l = 0;

        for(int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if(counts.containsKey(ch)) {
                counts.put(ch, counts.get(ch) - 1);

                if(counts.get(ch) == 0) {
                    MATCHES++;
                }
            }

            while(MATCHES == counts.size()) {
                if(r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
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

        return len <= s.length() ? s.substring(start, start + len) : "";
    }
}
