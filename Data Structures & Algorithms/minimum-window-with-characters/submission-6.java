class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> counts = new HashMap<>();
        for(char ch : t.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0)+1);
        }

        int matches = 0, lower = 0, l = 0, len = s.length()+1;

        for(int r=0; r<s.length(); r++) {
            char ch = s.charAt(r);
            if(counts.containsKey(ch)) {
                counts.put(ch, counts.get(ch)-1);
                if(counts.get(ch) == 0) {
                    matches++;
                }
            }
            while(matches == counts.size()) {
                if(r-l+1 < len) {
                    len = r-l+1;
                    lower = l;
                }

                ch = s.charAt(l++);
                if(counts.containsKey(ch)) {
                    counts.put(ch, counts.get(ch)+1);
                    if(counts.get(ch) == 1) {
                        matches--;
                    }
                }
            }
        }

        return len <= s.length() ? s.substring(lower, lower+len) : "";
    }
}
