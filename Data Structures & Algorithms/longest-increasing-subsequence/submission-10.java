class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);

        int LIS = 1;
        for(int i = 1; i < nums.length; i++) {
            if(dp.get(dp.size() - 1) < nums[i]) {
                dp.add(nums[i]);
                LIS++;
                continue;
            }

            int ind = binarySearch(dp, nums[i]);
            if(ind < 0) {
                ind = -ind - 1;
            }
            dp.set(ind, nums[i]);
        }
        return LIS;
    }

    private int binarySearch(List<Integer> dp, int target) {
        int l = 0, r = dp.size() - 1;

        while( l <= r ) {
            int m = l + (r - l) / 2;
            if(dp.get(m) == target) {
                return m;
            } else if (dp.get(m) > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -(l + 1);
    }
}
