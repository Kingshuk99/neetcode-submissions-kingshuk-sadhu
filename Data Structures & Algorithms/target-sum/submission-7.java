class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return calculateCombs(nums, 0, 0, target, dp);
    }

    private int calculateCombs(int[] nums, int ind, int sum, int target,
    Map<String, Integer> dp) {
        String key = ind + "-" + sum;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }
        if(ind==nums.length) {
            return sum == target ? 1 : 0;
        }

        int ways = calculateCombs(nums, ind+1, sum+nums[ind], target, dp) + 
        calculateCombs(nums, ind+1, sum-nums[ind], target, dp);
        dp.put(key, ways);
        return ways;
    }
}
