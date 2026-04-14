class Solution {
    public int countSubstrings(String s) {
        int ans = 0;

        for(int i=0; i<s.length(); i++) {
            //odd length
            int l = i, r = i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
                ans++;
                l--;
                r++;
            }

            //even length
            l = i;
            r = i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
                ans++;
                l--;
                r++;
            }
        }

        return ans;
    }
}
