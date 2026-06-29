class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        int[] counts = new int[26];

        for(int i=0; i<s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }

        int MATCHES = 0, l = 0;

        for(int i=0; i<26; i++) {
            if(counts[i] == 0) {
                MATCHES++;
            }
        }

        for(int r=s1.length(); r<s2.length(); r++) {
            if(MATCHES == 26) {
                return true;
            }

            int ind = s2.charAt(r) - 'a';
            counts[ind]--;

            if(counts[ind] == 0) {
                MATCHES++;
            } else if(counts[ind] == -1) {
                MATCHES--;
            }

            ind = s2.charAt(l++) - 'a';
            counts[ind]++;

            if(counts[ind] == 0) {
                MATCHES++;
            } else if(counts[ind] == 1) {
                MATCHES--;
            }
        }

        return MATCHES == 26;
    }
}
