class Solution {
    public int firstMissingPositive(int[] nums) {
        // Cycle sort
        int n = nums.length, i = 0;

        while(i < n) {
            if(nums[i] <= 0 || nums[i] > n) {
                i++;
                continue;
            }

            int ind = nums[i] - 1;
            if(nums[i] != nums[ind]) {
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
            } else {
                i++;
            }
        }

        for(i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}