class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // return solve(nums, target, 0);
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for(int num : nums) {
            Map<Integer, Integer> newDp = new HashMap<>();
            for(int key : dp.keySet()) {
                int count = dp.get(key);
                newDp.put(key + num, newDp.getOrDefault(key + num, 0) + count);
                newDp.put(key - num, newDp.getOrDefault(key - num, 0) + count);
            }
            dp = newDp;
        }

        return dp.getOrDefault(target, 0);
    }

    // private int solve(int[] nums, int target, int ind) {
    //     if(ind == nums.length) {
    //         return target == 0 ? 1 : 0;
    //     }

    //     return solve(nums, target + nums[ind], ind + 1) +
    //     solve(nums, target - nums[ind], ind + 1);
    // }
}
