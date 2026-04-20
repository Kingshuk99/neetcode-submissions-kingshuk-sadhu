class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs("", ans, 0, 0, n); //diff = left - right
        return ans;
    }

    private void dfs(String s, List<String> ans, int left, int right, int n) {
        if(n == left && n == right) {
            ans.add(s);
            return;
        }

        if(left >= right && n > left) {
            dfs(s + "(", ans, left + 1, right, n);
        }
        if(left > right && n >= left) {
            dfs(s + ")", ans, left, right + 1, n);
        }
    }
}
