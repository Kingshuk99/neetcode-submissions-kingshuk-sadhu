class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        backtrack(nums, 0);
        return ans;
    }

    private void backtrack(int[] nums, int ind) {
        if(ind == nums.length) {
            List<Integer> res = new ArrayList<>();
            for(int num : nums) {
                res.add(num);
            }
            ans.add(res);
            return;
        }

        for(int i = ind; i < nums.length; i++) {
            swap(nums, ind, i);
            backtrack(nums, ind + 1);
            swap(nums, ind, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
