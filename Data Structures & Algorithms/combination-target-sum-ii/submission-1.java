class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        if(candidates[0]>target) {
            return ans;
        }
        recurr(candidates, target, ans, res, 0);
        return ans;
    }

    private void recurr(int[] candidates, int target, List<List<Integer>> ans, 
    List<Integer> res, int ind) {
        if(target==0) {
            ans.add(new ArrayList<>(res));
            return;
        }

        if(ind==candidates.length) {
            return;
        }

        int i = ind;
        while(i<candidates.length-1 && candidates[i]==candidates[i+1]) {
            i++;
        }

        if(target>=candidates[ind]) {
            res.add(candidates[ind]);
            recurr(candidates, target-candidates[ind], ans, res, ind+1);
            res.remove(res.size()-1);
        }
        recurr(candidates, target, ans, res, i+1);
    }
}
