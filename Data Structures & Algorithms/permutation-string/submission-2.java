class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) {
            return false;
        }
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i=0; i<s1.length(); i++) {
            s1Count[s1.charAt(i)-'a']++;
            s2Count[s2.charAt(i)-'a']++;
        }

        int matches = 0;

        for(int i=0; i<26; i++) {
            if(s1Count[i]==s2Count[i]) {
                matches++;
            }
        }

        int l = 0;

        for(int r=s1.length(); r<s2.length(); r++) {
            if(matches==26) {
                return true;
            }

            int ind = s2.charAt(r)-'a';
            s2Count[ind]++;
            if(s2Count[ind]==s1Count[ind]) {
                matches++;
            } else if(s2Count[ind]==s1Count[ind]+1) {
                matches--;
            }

            ind = s2.charAt(l++)-'a';
            s2Count[ind]--;
            if(s2Count[ind]==s1Count[ind]) {
                matches++;
            } else if(s2Count[ind]==s1Count[ind]-1) {
                matches--;
            }
        }

        return matches==26;
    }
}
