class Solution {
    public int jump(int[] nums) {
        if(nums.length<=1) {
            return 0;
        }
        int steps = nums[0], maxPos = nums[0], jumps = 1;

        for(int i=1; i<nums.length; i++) {
            steps--;
            maxPos = Math.max(maxPos, i+nums[i]);

            if(maxPos<=i && i<nums.length-1) {
                return -1;
            }

            if(steps==0 && i<nums.length-1) {
                jumps++;
                steps = maxPos-i;
            }
        }

        return jumps;
    }
}
