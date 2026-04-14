class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length+2];
        arr[0] = arr[nums.length+1] = 1;
        for(int i=1; i<=nums.length; i++) {
            arr[i] = nums[i-1];
        }

        int[][] dp = new int[arr.length][arr.length];

        for(int i=1; i<=nums.length; i++) {
            dp[i][i] = arr[i-1]*arr[i]*arr[i+1];
        }

        for(int len=2; len<=nums.length; len++) {
            for(int i=1; i<=nums.length-len+1; i++) {
                int j = i+len-1;
                for(int k=i; k<=j; k++) {
                    dp[i][j] = Math.max(dp[i][j], 
                    dp[i][k-1]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j+1]);
                }
            }
        }

        return dp[1][nums.length];
    }
}
