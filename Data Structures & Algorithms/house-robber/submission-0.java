class Solution {
    public int rob(int[] nums) {
        int a = 0, b = nums[0];
        int c = nums[0];

        for(int i=1; i<nums.length; i++) {
            c = Math.max(b, a+nums[i]);
            a = b;
            b = c;
        }

        return c;
    }
}
