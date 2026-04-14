class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for(int num : nums) {
            Map<Integer, Integer> newDp = new HashMap<>();
            for(int key : dp.keySet()) {
                int value = dp.get(key);
                newDp.put(key + num, newDp.getOrDefault(key + num, 0) + value);
                newDp.put(key - num, newDp.getOrDefault(key - num, 0) + value);
            }
            dp = newDp;
        }
        return dp.getOrDefault(target, 0);
    }
}
