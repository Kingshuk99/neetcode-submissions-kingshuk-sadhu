class Solution {
    private List<String> ans = new ArrayList<>();
    private void buildParentheses(String s, int left, int right) {
        if(left==0 && right==0) {
            ans.add(s);
            return;
        }

        if(left<=right) {
            if(left>0) {
                buildParentheses(s+'(', left-1, right);
            }
            buildParentheses(s+')', left, right-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        int left = n, right = n;
        String s = "";
        buildParentheses(s, left, right);
        return ans;
    }
}
