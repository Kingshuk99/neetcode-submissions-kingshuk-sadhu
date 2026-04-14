class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> counts = new HashMap<>();

        for(char ch : t.toCharArray()) {
            if(!counts.containsKey(ch)) {
                counts.put(ch, 0);
            }
            counts.put(ch, counts.get(ch)+1);
        }

        int l = 0, matches = 0, len = s.length()+1, start = 0;
        for(int r=0; r<s.length(); r++) {
            char ch = s.charAt(r);
            if(counts.containsKey(ch)) {
                counts.put(ch, counts.get(ch)-1);
                if(counts.get(ch)==0) {
                    matches++;
                }
            }

            while(matches==counts.size()) {
                if(len > r-l+1) {
                    len = r-l+1;
                    start = l;
                }
                ch = s.charAt(l++);
                if(counts.containsKey(ch)) {
                    counts.put(ch, counts.get(ch)+1);
                    if(counts.get(ch)==1) {
                        matches--;
                    }
                }
            }
        }

        return len > s.length() ? "" : s.substring(start, start+len);
    }
}
