class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for(int i=0; i<n; i++) {
            arr[i+1] = nums[i];
        }

        // Sol 1
        // return solve(arr, 1, n);

        // Sol 2
        int[][] dp = new int[n+2][n+2];

        for(int i=1; i<=n; i++) {
            dp[i][i] = arr[i-1]*arr[i]*arr[i+1];
        }

        for(int len = 2; len <= n; len++) {
            for(int i = 1; i < n-len+2; i++) {
                int j = i+len-1;
                for(int k=i; k<=j; k++) {
                    dp[i][j] = Math.max(dp[i][j], 
                    dp[i][k-1]+arr[i-1]*arr[k]*arr[j+1]+dp[k+1][j]);
                }
            }
        }

        return dp[1][n];
    }

    private int solve(int[] arr, int start, int end) {
        if(start==end) {
            return arr[start-1]*arr[start]*arr[start+1];
        }

        int ans = 0;
        for(int i=start; i<=end; i++) {
            ans = Math.max(ans, solve(arr, start, i-1) + 
            arr[start-1]*arr[i]*arr[end+1] + solve(arr, i+1, end));
        }

        return ans;
    }
}
