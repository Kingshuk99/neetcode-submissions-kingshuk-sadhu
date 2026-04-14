class Solution {
    public int findDuplicate(int[] nums) {
        while(true) {
            int num = nums[0];
            if(nums[num]==num) {
                return num;
            }
            nums[0] = nums[num];
            nums[num] = num;
        }
    }
}
