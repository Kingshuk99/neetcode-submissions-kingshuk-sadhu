class Solution {
    public int maxProduct(int[] nums) {
        // Relies on the fact that max prod subarr will start 
        // from at least one end of the arr
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        int ans = nums[0];
        int prefix = 0, suffix = 0;

        for(int i = 0; i < n; i++) {
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[n - 1 - i] * (suffix == 0 ? 1 : suffix);
            ans = Math.max(ans, Math.max(prefix, suffix));
        }

        return ans;
    }
}
