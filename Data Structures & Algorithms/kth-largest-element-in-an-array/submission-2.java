class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, r = nums.length-1;

        while(l < r) {
            int pivot = partition(nums, l, r);
            if(k < pivot) {
                r = pivot - 1;
            } else if(k > pivot) {
                l = pivot + 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    private int partition(int[] nums, int left, int right) {
        int pivotVal = nums[right], partitionPoint = left;
        for(int i=left; i<right; i++) {
            if(nums[i] <= pivotVal) {
                int temp = nums[i];
                nums[i] = nums[partitionPoint];
                nums[partitionPoint++] = temp;
            }
        }

        nums[right] = nums[partitionPoint];
        nums[partitionPoint] = pivotVal;
        return partitionPoint;
    }
}
