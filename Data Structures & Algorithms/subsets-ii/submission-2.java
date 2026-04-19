class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, ans, res);
        return ans;
    }

    private void dfs(int[] nums, int ind, 
    List<List<Integer>> ans, List<Integer> res) {
        if(ind == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[ind]);
        dfs(nums, ind + 1, ans, res);
        int i = ind;
        res.remove(res.size() - 1);
        while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(nums, i + 1, ans, res);
    }
}
