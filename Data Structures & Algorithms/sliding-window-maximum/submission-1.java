class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];

        int l = 0;

        for(int r=0; r<nums.length; r++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.pollLast();
            }
            deque.offer(r);

            if(l>deque.peekFirst()) {
                deque.pollFirst();
            }

            if(r+1>=k) {
                ans[l] = nums[deque.peekFirst()];
                l++;
            }
        }
        return ans;
    }
}
