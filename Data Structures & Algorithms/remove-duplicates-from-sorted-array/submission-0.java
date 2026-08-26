class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while(j < nums.length) {
            nums[i] = nums[j];
            i++;
            while(j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j++;
            }
            j++;
        }
        return i;
    }
}