class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) {
            return 0;
        }
        int l = 0, r = 0, len = 1;
        Set<Character> exists = new HashSet<>();
        while(r<s.length()) {
            while(exists.contains(s.charAt(r))) {
                exists.remove(s.charAt(l++));
            }
            exists.add(s.charAt(r));
            len = Math.max(len, r-l+1);
            r++;
        }
        return len;
    }
}
