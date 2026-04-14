class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, r = nums.length-1;
        while(l<r) {
            int pivotPoint = partition(nums, l, r);
            if(k<pivotPoint) {
                r = pivotPoint - 1;
            } else if(k>pivotPoint) {
                l = pivotPoint + 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    private int partition(int[] nums, int l, int r) {
        int partitionPoint = l;

        for(int i=l; i<r; i++) {
            if(nums[i]<=nums[r]) {
                int temp = nums[partitionPoint];
                nums[partitionPoint++] = nums[i];
                nums[i] = temp;
            }
        }

        int temp = nums[r];
        nums[r] = nums[partitionPoint];
        nums[partitionPoint] = temp;
        return partitionPoint;
    }
}
