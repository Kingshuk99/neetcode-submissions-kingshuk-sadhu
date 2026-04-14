class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0], currMax = 1, currMin = 1;

        for(int num : nums) {
            int temp = currMax;
            currMax = Math.max(Math.max(currMax*num, currMin*num), num);
            currMin = Math.min(Math.min(temp*num, currMin*num), num);
            ans = Math.max(ans, currMax);
        }

        return ans;
    }
}
