class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, ans, 0, target);
        return ans;
    }

    private void dfs(int[] nums, List<Integer> res, List<List<Integer>> ans,
    int ind, int rem) {
        if(rem < 0) {
            return;
        }
        if(rem == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i = ind; i < nums.length; i++) {
            res.add(nums[i]);
            dfs(nums, res, ans, i, rem - nums[i]);
            res.remove(res.size() - 1);
        }
    }
}
