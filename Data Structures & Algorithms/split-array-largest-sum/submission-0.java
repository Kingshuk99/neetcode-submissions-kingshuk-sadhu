class Solution {
    private int[] prefix;
    private int n;

    public int splitArray(int[] nums, int k) {
        n = nums.length;
        prefix = new int[n + 1];
        int l = Integer.MIN_VALUE, r = 0;

        for(int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
            l = Math.max(l, nums[i]);
            r += nums[i];
        }

        int sum = r;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(canSplit(mid, k)) {
                sum = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return sum;
    }

    private boolean canSplit(int largest, int k) {
        int count = 0, i = 0;
        while(i < n) {
            int l = i + 1, r = n;
            while(l <= r) {
                int mid = l + (r - l) / 2;
                if(prefix[mid] - prefix[i] <= largest) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            count++;
            i = r;
            if(count > k) {
                return false;
            }
        }
        return true;
    }
}