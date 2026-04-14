class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    private void dfs(int[] nums, int target, int ind, List<Integer> res) {
        if(target==0) {
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i=ind; i<nums.length; i++) {
            if(nums[i]<=target) {
                res.add(nums[i]);
                dfs(nums, target-nums[i], i, res);
                res.remove(res.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        dfs(nums, target, 0, res);
        return ans;
    }
}
