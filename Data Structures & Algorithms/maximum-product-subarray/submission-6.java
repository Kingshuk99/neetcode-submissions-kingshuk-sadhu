class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0], maxProd = 1, minProd = 1;

        for(int num : nums) {
            int temp = maxProd;
            maxProd = Math.max(num, Math.max(maxProd*num, minProd*num));
            minProd = Math.min(num, Math.min(temp*num, minProd*num));
            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
}
