class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
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
        int i = ind;
        while(i<nums.length-1 && nums[i]==nums[i+1]) {
            i++;
        }
        recurr(nums, ans, res, i+1);
    }
}
