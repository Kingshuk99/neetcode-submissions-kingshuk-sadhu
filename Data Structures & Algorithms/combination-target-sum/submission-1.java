class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        recurr(nums, target, ans, res, 0);
        return ans;
    }
    private void recurr(int[] nums, int target, List<List<Integer>> ans, 
    List<Integer> res, int i) {
        if(target==0) {
            ans.add(new ArrayList<>(res));
            return;
        }
        if(i==nums.length) {
            return;
        }

        if(nums[i]<=target) {
            res.add(nums[i]);
            recurr(nums, target-nums[i], ans, res, i);
            res.remove(res.size()-1);
        }
        recurr(nums, target, ans, res, i+1);
    }
}
