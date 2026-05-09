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

            int ind = Collections.binarySearch(dp, nums[i]);
            if(ind < 0) {
                ind = -ind - 1;
            }
            dp.set(ind, nums[i]);
        }

        return LIS;
    }
}
