class KthLargest {
    private int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size()>this.k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size()>k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
