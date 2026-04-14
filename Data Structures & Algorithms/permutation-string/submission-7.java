class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];

        for(int i=0; i<s1.length(); i++) {
            countS1[s1.charAt(i)-'a']++;
            countS2[s2.charAt(i)-'a']++;
        }

        int l = 0, matches = 0;
        for(int i=0; i<26; i++) {
            if(countS1[i] == countS2[i]) {
                matches++;
            }
        }

        for(int r=s1.length(); r<s2.length(); r++) {
            if(matches == 26) {
                return true;
            }

            int ind = s2.charAt(r)-'a';
            countS2[ind]++;
            if(countS2[ind] == countS1[ind]) {
                matches++;
            } else if(countS2[ind] == countS1[ind]+1) {
                matches--;
            }

            ind = s2.charAt(l++)-'a';
            countS2[ind]--;
            if(countS2[ind] == countS1[ind]) {
                matches++;
            } else if(countS2[ind] == countS1[ind]-1) {
                matches--;
            }
        }

        return matches == 26;
    }
}
