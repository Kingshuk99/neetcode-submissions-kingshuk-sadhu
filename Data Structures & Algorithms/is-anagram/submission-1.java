class Solution {
    public boolean isAnagram(String s, String t) {
        int[] vis = new int[26];
        for(char ch :  s.toCharArray()) {
            vis[ch-'a']++;
        }
        for(char ch : t.toCharArray()) {
            vis[ch-'a']--;
        }

        for(int i=0; i<26; i++) {
            if(vis[i]!=0) {
                return false;
            }
        }

        return true;
    }
}
