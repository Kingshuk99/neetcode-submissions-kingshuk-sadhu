class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private void dfs(int[] candidates, List<Integer> res, int target, int ind) {
        if(target==0) {
            ans.add(new ArrayList<>(res));
            return;
        }

        if(target<0) {
            return;
        }

        int prev = -1;
        for(int i=ind; i<candidates.length; i++) {
            if(candidates[i]==prev) {
                continue;
            }
            res.add(candidates[i]);
            dfs(candidates, res, target-candidates[i], i+1);
            res.remove(res.size()-1);
            prev = candidates[i];
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, new ArrayList<>(), target, 0);
        return ans;
    }
}
