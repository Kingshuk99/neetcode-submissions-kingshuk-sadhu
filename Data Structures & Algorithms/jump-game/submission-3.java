class Solution {
    public boolean canJump(int[] nums) {
        int maxPoint = 0, step = 0;
        for(int i = 0; i < nums.length; i++) {
            maxPoint = Math.max(maxPoint, i + nums[i]);

            if(step == i) {
                step = maxPoint;
            }
            System.out.println(step);

            if(i != nums.length - 1 && step <= i) {
                return false;
            }
        }

        return true;
    }
}
