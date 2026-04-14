class Solution {
    int ind = -1;
    public int findKthLargest(int[] nums, int k) {
        ind = nums.length-k;
        return quickSelect(0, nums.length-1, nums);
    }

    private int quickSelect(int l, int r, int[] nums) {
        int pivot = nums[r], p = l;

        for(int i=l; i<r; i++) {
            if(nums[i]<=pivot) {
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
            }
        }

        int temp = nums[p];
        nums[p] = nums[r];
        nums[r] = temp;

        if(p>ind) {
            return quickSelect(l, p-1, nums);
        }
        else if(p<ind) {
            return quickSelect(p+1, r, nums);
        }
        else {
            return nums[p];
        }
    }
}
