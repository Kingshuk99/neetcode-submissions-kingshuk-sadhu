class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, sum = 0, minLen = nums.length + 1, minSum = 0;
        for(int r = 0; r < nums.length; r++) {
            sum += nums[r];
            if(sum >= target) {
                while(l <= r && sum >= target) {
                    sum -= nums[l++];
                }
                minLen = Math.min(minLen, r - l + 2);
            }
        }
        return minLen <= nums.length ? minLen : 0;
    }
}