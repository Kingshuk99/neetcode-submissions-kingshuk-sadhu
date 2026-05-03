class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if( n == 0) {
            return 0;
        }

        if(n == 1) {
            return nums[0];
        }

        return Math.max(helper(Arrays.copyOfRange(nums, 1, n)),
        helper(Arrays.copyOfRange(nums, 0, n - 1)));
    }

    private int helper(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return nums[0];
        }

        int a = 0, b = 0;

        for(int num : nums) {
            int c = Math.max(a + num, b);
            a = b;
            b = c;
        }

        return b;
    }
}
