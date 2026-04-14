class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        recurr(nums, ans, res, 0);
        return ans;
    }
    
    private void recurr(int[] nums, List<List<Integer>> ans, List<Integer> res, int ind) {
        if(ind==nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[ind]);
        recurr(nums, ans, res, ind+1);
        res.remove(res.size()-1);
        recurr(nums, ans, res, ind+1);
    }
}
