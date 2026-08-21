class Solution {
    public void sortColors(int[] nums) {
        int l = 0, m = 0, r = nums.length - 1;

        while(m <= r) {
            if(nums[m] == 0) {
                swap(nums, m++, l++);
            } else if(nums[m] == 1) {
                m++;
            } else {
                swap(nums, m, r--);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}