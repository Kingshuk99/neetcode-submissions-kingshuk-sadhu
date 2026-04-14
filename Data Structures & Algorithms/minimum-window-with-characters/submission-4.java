class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        int l = 0, start = 0, len = s.length()+1, matches = 0;
        Map<Character, Integer> counts = new HashMap<>();

        for(int i=0; i<t.length(); i++) {
            counts.put(t.charAt(i), counts.getOrDefault(t.charAt(i), 0)+1);
        }

        for(int r=0; r<s.length(); r++) {
            if(counts.containsKey(s.charAt(r))) {
                counts.put(s.charAt(r), counts.get(s.charAt(r))-1);
                if(counts.get(s.charAt(r))==0) {
                    matches++;
                }
            }
            while(matches==counts.size()) {
                if(len > r-l+1) {
                    start = l;
                    len = r-l+1;
                }
                if(counts.containsKey(s.charAt(l))) {
                    if(counts.get(s.charAt(l))==0) {
                        matches--;
                    }
                    counts.put(s.charAt(l), counts.get(s.charAt(l))+1);
                }
                l++;
            }
        }

        return len > s.length() ? "" : s.substring(start, start+len);
    }
}
