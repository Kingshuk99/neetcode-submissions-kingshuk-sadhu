class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0], currMax = 1, currMin = 1;

        for(int n:nums) {
            int temp = currMax*n;
            currMax = Math.max(Math.max(currMax*n, currMin*n), n);
            currMin = Math.min(Math.min(temp, currMin*n), n);
            ans = Math.max(ans, currMax);
        }

        return ans;
    }
}
