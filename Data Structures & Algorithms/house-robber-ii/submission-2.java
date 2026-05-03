class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[][] dp = new int[2][nums.length];
        dp[0][0] = nums[0];

        for(int i = 1; i < nums.length - 1; i++) {
            int temp0 = i > 1 ? dp[0][i - 2] : 0;
            int temp1 = i > 1 ? dp[1][i - 2] : 0;
            dp[0][i] = Math.max(dp[0][i - 1], nums[i] + temp0);
            dp[1][i] = Math.max(dp[1][i - 1], nums[i] + temp1);
        }

        dp[0][nums.length - 1] = dp[0][nums.length - 2];
        dp[1][nums.length - 1] = Math.max(dp[1][nums.length - 2],
        dp[1][nums.length - 3] + nums[nums.length - 1]);

        return Math.max(dp[0][nums.length - 1], dp[1][nums.length - 1]);
    }
}
