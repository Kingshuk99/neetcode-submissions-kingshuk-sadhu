class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int l = 1; l <= n; l++) {
            for(int i = 0; i < n - l + 1; i++) {
                dp[i][i + l - 1] = s.charAt(i) == s.charAt(i + l - 1) && 
                (i + 1 > i + l - 2 || dp[i + 1][i + l - 2]);
            }
        }

        return dfs(s, dp, 0);
    }

    private List<List<String>> dfs(String s, boolean[][] dp, int i) {
        if(i >= s.length()) {
            return new ArrayList<List<String>>() {{
                add(new ArrayList<>());
            }};
        }

        List<List<String>> ans = new ArrayList<>();

        for(int j = i; j < s.length(); j++) {
            if(dp[i][j]) {
                List<List<String>> next = dfs(s, dp, j + 1);
                for(List<String> temp : next) {
                    List<String> res = new ArrayList<>();
                    res.add(s.substring(i, j + 1));
                    res.addAll(temp);
                    ans.add(res);
                }
            }
        }

        return ans;
    }
}
