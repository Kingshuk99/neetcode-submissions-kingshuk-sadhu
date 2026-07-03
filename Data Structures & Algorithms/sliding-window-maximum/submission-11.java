class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Better solution
        int[] maxVals = new int[nums.length - k + 1];
        int l = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for(int r = 0; r < nums.length; r++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.pollLast();
            }

            deque.offerLast(r);

            if(l > deque.peekFirst()) {
                deque.pollFirst();
            }

            if(r + 1 >= k) {
                maxVals[l++] = nums[deque.peekFirst()];
            }
        }

        return maxVals;
    }
}
