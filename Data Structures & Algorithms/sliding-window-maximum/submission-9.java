class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Not better but complexity wise same
        int n = nums.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];

        for(int i = 1; i < n; i++) {
            if(i % k == 0) {
                leftMax[i] = nums[i];
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
            }

            int endI = n - 1 - i;
            if(endI % k == 0) {
                rightMax[endI] = nums[endI];
            } else {
                rightMax[endI] = Math.max(rightMax[endI + 1], nums[endI]);
            }
        }

        int[] maxVals = new int[n - k + 1];

        for(int i = 0; i < n - k + 1; i++) {
            maxVals[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
        }

        return maxVals;
    }
}
