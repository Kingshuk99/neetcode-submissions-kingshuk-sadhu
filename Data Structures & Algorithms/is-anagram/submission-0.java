class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }

        int[] charSet = new int[26];
        for(int i=0; i<s.length(); i++) {
            charSet[s.charAt(i)-'a']++;
            charSet[t.charAt(i)-'a']--;
        }

        for(int x:charSet) {
            if(x!=0) {
                return false;
            }
        }

        return true;
    }
}
