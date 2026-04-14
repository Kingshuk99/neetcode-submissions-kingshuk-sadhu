class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] counts = new int[26];
        int l = 0;

        for(int i=0; i<s1.length(); i++) {
            counts[s1.charAt(i)-'a']++;
            counts[s2.charAt(i)-'a']--;
        }

        int matches = 0;

        for(int i=0; i<26; i++) {
            matches += (counts[i]==0 ? 1 : 0);
        }

        for(int r=s1.length(); r<s2.length(); r++) {
            if(matches == 26) {
                return true;
            }

            char ch = s2.charAt(r);
            counts[ch-'a']--;
            if(counts[ch-'a'] == 0) {
                matches++;
            } else if(counts[ch-'a']==-1) {
                matches--;
            }

            ch = s2.charAt(l++);
            counts[ch-'a']++;
            if(counts[ch-'a'] == 0) {
                matches++;
            } else if(counts[ch-'a'] == 1) {
                matches--;
            }
        }

        return matches==26;
    }
}
