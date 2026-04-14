class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(0, 0, nums, target);
    }

    private int backtrack(int i, int total, int[] nums, int target) {
        if(i == nums.length) {
            return target == total ? 1 : 0;
        }
        
        String key = i + "-" + total;

        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int ways = backtrack(i+1, total + nums[i], nums, target) +
                    backtrack(i+1, total - nums[i], nums, target);

        dp.put(key, ways);
        return ways;
    }
}
