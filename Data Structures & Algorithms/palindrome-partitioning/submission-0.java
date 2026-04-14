class Solution {
    private List<List<String>> ans = new ArrayList<>();
    private boolean isPalindrome(String s) {
        int n = s.length();
        if(n<=1) {
            return true;
        }
        int i=0;
        n--;
        while(i<n) {
            if(s.charAt(i++)!=s.charAt(n--)) {
                return false;
            }
        }
        return true;
    }
    private void dfs(String s, List<String> res) {
        if(s=="") {
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i=0; i<s.length(); i++) {
            String firstPart = s.substring(0, i+1);
            if(isPalindrome(firstPart)) {
                res.add(firstPart);
                dfs(s.substring(i+1), res);
                res.remove(res.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<>());
        return ans;
    }
}
