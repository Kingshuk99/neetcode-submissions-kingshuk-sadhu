class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> vis = new HashSet<>();
        int l = 0, len = 0;
        for(int r=0; r<s.length(); r++) {
            while(vis.contains(s.charAt(r))) {
                vis.remove(s.charAt(l++));
            }
            vis.add(s.charAt(r));
            len = Math.max(len, r-l+1);
        }

        return len;
    }
}
