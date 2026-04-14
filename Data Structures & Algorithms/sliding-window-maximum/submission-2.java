class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];

        for(int r=0; r<nums.length; r++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.pollLast();
            }
            deque.offer(r);
            if(l>deque.peekFirst()) {
                deque.pollFirst();
            }
            if(r+1>=k) {
                ans[l++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
