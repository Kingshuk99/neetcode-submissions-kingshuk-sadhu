class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0, 0, new HashMap<>());
    }

    private int solve(int[] nums, int target, int i, int sum, Map<String, Integer> hashMap) {
        if(i==nums.length) {
            return target == sum ? 1 : 0;
        }
        String key = i + "-" + sum;
        if(hashMap.containsKey(key)) {
            return hashMap.get(key);
        }

        int count = 0;
        count += (solve(nums, target, i+1, sum+nums[i], hashMap) + 
        solve(nums, target, i+1, sum-nums[i], hashMap));

        hashMap.put(key, count);
        return count;
    }
}
