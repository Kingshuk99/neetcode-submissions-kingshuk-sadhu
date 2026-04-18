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

        int i = ind;

        while(i < candidates.length - 1 && 
        candidates[i] == candidates[i + 1]) {
            i++;
        }

        res.add(candidates[ind]);
        dfs(candidates, rem - candidates[ind], ans, res, ind + 1);
        res.remove(res.size() - 1);
        dfs(candidates, rem, ans, res, i + 1);
    }
}
