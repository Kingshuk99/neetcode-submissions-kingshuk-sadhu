class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        k = nums.length - k;

        while(l < h) {
            int pivot = quickSelect(nums, l, h);
            if(pivot > k) {
                h = pivot - 1;
            } else if (pivot < k){
                l = pivot + 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    private int quickSelect(int[] nums, int l, int h) {
        int pivot = l;
        for(int i=l; i<h; i++) {
            if(nums[i] < nums[h]) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot++] = temp;
            }
        }
        int temp = nums[h];
        nums[h] = nums[pivot];
        nums[pivot] = temp;
        return pivot;
    }
}
