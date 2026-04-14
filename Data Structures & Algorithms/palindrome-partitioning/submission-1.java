class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();

        recurr(ans, res, s);
        return ans;
    }

    private void recurr(List<List<String>> ans, List<String> res, String s) {
        if(s=="") {
            ans.add(new ArrayList<>(res));
            return;
        }

        int left = 0;
        for(int right=0; right<s.length(); right++) {
            if(isPalindrome(s, left, right)) {
                res.add(s.substring(left, right+1));
                recurr(ans, res, s.substring(right+1));
                res.remove(res.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left<right) {
            if(s.charAt(left++)!=s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
