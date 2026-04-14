class Solution {
    public List<String> generateParenthesis(int n) {
        String s = "";
        List<String> ans = new ArrayList<>();
        util(s, n, n, ans);
        return ans;
    }
    private void util(String s, int left, int right, List<String> ans) {
        if(left==0 && right==0) {
            ans.add(s);
            return;
        }

        if(left<=right) {
            if(left>0) {
                util(s+'(', left-1, right, ans);
            }
            util(s+')', left, right-1, ans);
        }
    }
}
