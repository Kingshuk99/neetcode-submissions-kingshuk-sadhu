class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = 1, minProd = 1, ans = nums[0];

        for(int num : nums) {
            int currMaxProd = maxProd;
            maxProd = Math.max(num, Math.max(maxProd*num, minProd*num));
            minProd = Math.min(num, Math.min(minProd*num, currMaxProd*num));
            ans = Math.max(maxProd, ans);
        }

        return ans;
    }
}
