class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();

        for(int num : nums) {
            if(dp.size() == 0 || dp.get(dp.size() - 1) < num) {
                dp.add(num);
                continue;
            }
            int ind = binarySearch(dp, num);
            if(ind < 0) {
                ind = -ind - 1;
            }
            dp.set(ind, num);
        }
        return dp.size();
    }

    private int binarySearch(List<Integer> dp, int num) {
        int l = 0, r = dp.size() - 1;

        while(l <= r) {
            int m = l + (r - l) / 2;
            if(dp.get(m) == num) {
                return m;
            } else if(dp.get(m) > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -(l + 1);
    }
}
