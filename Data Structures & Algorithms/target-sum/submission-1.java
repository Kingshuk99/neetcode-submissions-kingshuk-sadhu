class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return backTrack(nums, dp, target, 0, 0);
    }

    private int backTrack(int[] nums, Map<String, Integer> dp, 
    int target, int total, int ind) {
        if(ind==nums.length) {
            return target == total ? 1 : 0;
        }

        String key = ind + "-" + total;

        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int ways = backTrack(nums, dp, target, total + nums[ind], ind+1)
        + backTrack(nums, dp, target, total - nums[ind], ind+1);

        dp.put(key, ways);
        return ways;
    }
}
