class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(candidates, target, ans, res, 0);
        return ans;
    }

    private void dfs(int[] candidates, int rem, List<List<Integer>> ans, 
    List<Integer> res, int ind) {
        if(rem == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }

        if(rem < 0 || ind >= candidates.length) {
            return;
        }

        for(int i = ind; i < candidates.length; i++) {
            res.add(candidates[i]);
            dfs(candidates, rem - candidates[i], ans, res, i + 1);
            res.remove(res.size() - 1);
            while(i < candidates.length - 1 && 
            candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}
