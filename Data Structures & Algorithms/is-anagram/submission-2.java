class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] vis = new int[26];
        for(int i=0; i<s.length(); i++) {
            vis[s.charAt(i)-'a']++;
            vis[t.charAt(i)-'a']--;
        }
        
        for(int x : vis) {
            if(x!=0) {
                return false;
            }
        }

        return true;
    }
}
