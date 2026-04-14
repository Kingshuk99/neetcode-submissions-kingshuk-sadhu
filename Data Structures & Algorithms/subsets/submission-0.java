class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private void helper(List<Integer> res, int[] nums, int i) {
        if(i>=nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[i]);
        helper(res, nums, i+1);
        res.remove(res.size()-1);
        helper(res, nums, i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> res = new ArrayList<>();
        helper(res, nums, 0);
        return ans;
    }
}
