class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int ans = nums[0], maxProd = 1, minProd = 1;

        for(int num : nums) {
            int temp = maxProd * num;
            maxProd = Math.max(num, Math.max(temp, minProd * num));
            minProd = Math.min(num, Math.min(temp, minProd * num));

            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
}
