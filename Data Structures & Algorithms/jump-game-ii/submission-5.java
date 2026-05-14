class Solution {
    public int jump(int[] nums) {
        int steps = 0, maxPoint = 0, jumps = 0;
        for(int i = 0; i < nums.length; i++) {
            maxPoint = Math.max(maxPoint, i + nums[i]);
            if(steps == i) {
                steps = maxPoint;
                if(i != nums.length - 1) jumps++;
            }

            if(i != nums.length - 1 && steps <= i) {
                return -1;
            }
        }

        return jumps;
    }
}
