class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return calculateCombs(nums, 0, 0, target);
    }

    private int calculateCombs(int[] nums, int ind, int sum, int target) {
        if(ind==nums.length) {
            return sum == target ? 1 : 0;
        }

        return calculateCombs(nums, ind+1, sum+nums[ind], target) + 
        calculateCombs(nums, ind+1, sum-nums[ind], target);
    }
}
