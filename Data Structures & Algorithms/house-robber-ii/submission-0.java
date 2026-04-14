class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) {
            return nums[0];
        }

        if(n==2) {
            return Math.max(nums[0], nums[1]);
        }

        if(n==3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }

        int[][] dp = new int[2][n+1];

        dp[0][0] = dp[1][0] = dp[1][1] = 0;
        dp[0][1] = nums[0];

        for(int i=2; i<n; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2]+nums[i-1]);
            dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2]+nums[i-1]);
        }

        dp[0][n] = dp[0][n-1];
        dp[1][n] = Math.max(dp[1][n-1], dp[1][n-2]+nums[n-1]);

        return Math.max(dp[0][n], dp[1][n]);
    }
}