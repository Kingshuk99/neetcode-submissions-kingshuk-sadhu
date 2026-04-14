class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        if(s.length()==0) {
            return 0;
        }
        int l = 0, r = 0, ans = 1;
        while(r<s.length()) {
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
