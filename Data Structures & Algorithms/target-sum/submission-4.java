class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return solve(nums, 0, 0, target, dp);
    }

    private int solve(int[] nums, int ind, int total, int target, 
    Map<String, Integer> dp) {
        if(ind==nums.length) {
            return total == target ? 1 : 0;
        }

        String key = total + "-" + ind;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int ways = solve(nums, ind+1, total+nums[ind], target, dp) + 
        solve(nums, ind+1, total-nums[ind], target, dp);

        dp.put(key, ways);
        return ways;
    }
}
