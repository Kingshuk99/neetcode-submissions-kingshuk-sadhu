class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = arr[nums.length + 1] = 1;
        for(int i = 1; i <= nums.length; i++) {
            arr[i] = nums[i - 1];
        }

        // return solve(arr, 1, nums.length);

        int[][] dp = new int[arr.length][arr.length];

        for(int len = 1; len <= nums.length; len++) {
            for(int l = 1; l <= nums.length - len + 1; l++) {
                int r = l + len - 1;

                if(l == r) {
                    dp[l][r] = arr[l - 1] * arr[l] * arr[r + 1];
                    continue;
                }

                if(len == 2) {
                    dp[l][r] = Math.max(dp[l][r - 1] + arr[l - 1] * arr[r] * arr[r + 1],
                        dp[l + 1][r] + arr[l - 1] * arr[l] * arr[r + 1]);
                    continue;
                }

                for(int i = l; i <= r; i++) {
                    dp[l][r] = Math.max(dp[l][r], dp[l][i - 1] + 
                    dp[i + 1][r] + arr[l - 1] * arr[i] * arr[r + 1]);
                }
            }
        }

        return dp[1][nums.length];

    }

    // private int solve(int[] arr, int l, int len) {
    //     int r = l + len - 1;

    //     if(l > r) {
    //         return 0;
    //     }

    //     if(l == r) {
    //         return arr[l - 1] * arr[l] * arr[r + 1];
    //     }

    //     if(len == 2) {
    //         return Math.max(solve(arr, l, len - 1) + arr[l - 1] * arr[r] * arr[r + 1],
    //         solve(arr, l + 1, len - 1) + arr[l - 1] * arr[l] * arr[r + 1]);
    //     }

    //     int ans = 0;

    //     for(int i = l; i <= r; i++) {
    //         ans = Math.max(ans, solve(arr, l, i - l) + 
    //         solve(arr, i + 1, r - i) + arr[l - 1] * arr[i] * arr[r + 1]);
    //     }

    //     return ans;
    // }
}
