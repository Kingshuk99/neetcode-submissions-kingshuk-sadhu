class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private void dfs(int[] nums, int ind, List<Integer> res) {
        ans.add(new ArrayList<>(res));
        System.out.println(res);

        for(int i=ind; i<nums.length; i++) {
            if(i>ind && nums[i]==nums[i-1]) {
                continue;
            }
            res.add(nums[i]);
            dfs(nums, i+1, res);
            res.remove(res.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
}
