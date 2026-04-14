class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        int jumps = 1, steps = nums[0], maxPos = nums[0];

        for(int i=1; i<nums.length; i++) {
            steps--;
            maxPos = Math.max(maxPos, i+nums[i]);

            if(i<nums.length-1 && maxPos<=i) {
                return -1;
            }

            if(i<nums.length-1 && steps==0) {
                jumps++;
                steps = maxPos - i;
            }
        }

        return jumps;
    }
}
