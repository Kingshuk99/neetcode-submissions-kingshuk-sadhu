class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(sum%2!=0) {
            return false;
        }

        sum /= 2;

        boolean[] dp = new boolean[sum+1];

        dp[0] = true; 

        for(int i=0; i<nums.length; i++) {
            boolean[] newDp = new boolean[sum+1];
            newDp[0] = true;
            for(int j=1; j<=sum; j++) {
                newDp[j] = dp[j];
                if(nums[i]>j) {
                    continue;
                }
                newDp[j] |= dp[j-nums[i]];
            }
            dp = newDp;
        }

        return dp[sum];
    }
}
