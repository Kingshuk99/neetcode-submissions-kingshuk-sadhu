class Solution {
    Map<Character, String> hash;
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        hash = Map.of('2', "abc", '3', "def", '4', "ghi", 
        '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

        ans = new ArrayList<>();
        if(digits.length()==0) {
            return ans;
        }

        dfs(digits, "");

        return ans;
    }

    private void dfs(String digits, String res) {
        if(res.length()==digits.length()) {
            ans.add(res);
            return;
        }

        int ind = res.length();
        String correspondingStr = hash.get(digits.charAt(ind));

        for(char c : correspondingStr.toCharArray()) {
            dfs(digits, res+c);
        }
    }
}
