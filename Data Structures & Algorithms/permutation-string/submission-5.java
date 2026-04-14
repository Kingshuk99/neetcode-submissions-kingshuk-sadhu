class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) {
            return false;
        }

        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];

        for(int i=0; i<s1.length(); i++) {
            s1Counts[s1.charAt(i)-'a']++;
            s2Counts[s2.charAt(i)-'a']++;
        }

        int l = 0, matches = 0;

        for(int i=0; i<26; i++) {
            if(s1Counts[i]==s2Counts[i]) {
                matches++;
            }
        }

        for(int r=s1.length(); r<s2.length(); r++) {
            if(matches==26) {
                return true;
            }

            int ind = s2.charAt(r)-'a';

            s2Counts[ind]++;
            if(s1Counts[ind]==s2Counts[ind]) {
                matches++;
            } else if(s2Counts[ind]==s1Counts[ind]+1) {
                matches--;
            }

            ind = s2.charAt(l++)-'a';
            s2Counts[ind]--;
            if(s1Counts[ind]==s2Counts[ind]) {
                matches++;
            } else if(s2Counts[ind]==s1Counts[ind]-1) {
                matches--;
            }
        }

        return matches==26;
    }
}
