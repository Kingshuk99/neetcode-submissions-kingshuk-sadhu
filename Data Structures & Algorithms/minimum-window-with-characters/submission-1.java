class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length() || t.length()==0) {
            return "";
        }
        Map<Character, Integer> counts = new HashMap<>();
        for(char ch : t.toCharArray()) {
            if(!counts.containsKey(ch)) {
                counts.put(ch, 0);
            }
            counts.put(ch, counts.get(ch)+1);
        }

        int start = 0, l = 0, len = s.length()+1, matches = 0;

        for(int r=0; r<s.length(); r++) {
            char right = s.charAt(r);
            if(counts.containsKey(right)) {
                counts.put(right, counts.get(right)-1);
                if(counts.get(right)==0) {
                    matches++;
                }
            }
            while(matches==counts.size()) {
                if(len > r-l+1) {
                    len = r-l+1;
                    start = l;
                }
                char left = s.charAt(l++);
                if(counts.containsKey(left)) {
                    if(counts.get(left)==0) {
                        matches--;
                    }
                    counts.put(left, counts.get(left)+1);
                }
            }
        }

        return len > s.length() ? "" : s.substring(start, start+len);
    }
}
