class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1, pivot = nums.length;
        k = nums.length - k;
        while(pivot != k) {
            pivot = partition(nums, l, r);
            if(pivot < k) {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }

        return nums[pivot];
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = r, pivotEle = nums[pivot];

        int i = l;
        for(int j = l; j < r; j++) {
            if(nums[j] < pivotEle) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i++] = temp;
            }
        }

        int temp = nums[i];
        nums[i] = nums[pivot];
        nums[pivot] = temp;
        return i;
    }
}
