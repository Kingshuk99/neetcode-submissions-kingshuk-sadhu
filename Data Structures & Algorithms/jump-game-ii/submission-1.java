class Solution {
    public int jump(int[] nums) {
        if(nums.length<=1) {
            return 0;
        }
        int jumps = 1, steps = nums[0], maxInd = nums[0];

        for(int i=1; i<nums.length; i++) {
            steps--;
            maxInd = Math.max(maxInd, i+nums[i]);
            if(i<nums.length-1 && maxInd<=i) {
                return -1;
            }
            if(i<nums.length-1 && steps==0) {
                jumps++;
                steps = maxInd-i;
            }
        }
        return jumps;
    }
}
