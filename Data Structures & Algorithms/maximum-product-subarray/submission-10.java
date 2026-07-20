class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int maxProd = nums[0], currMax = 1, currMin = 1;

        for(int num : nums) {
            int temp = currMax * num;
            currMax = Math.max(num, Math.max(temp, currMin * num));
            currMin = Math.min(num, Math.min(temp, currMin * num));
            maxProd = Math.max(maxProd, currMax);
        }

        return maxProd;
    }
}
