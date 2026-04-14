class MedianFinder {
    private PriorityQueue<Integer> minHeap, maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if(maxHeap.size()-minHeap.size()>1 || (!minHeap.isEmpty() && 
        maxHeap.peek()>minHeap.peek())) {
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size()-maxHeap.size()>1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        return minHeap.size() == maxHeap.size() ? (double)(minHeap.peek() + maxHeap.peek())/2 : 
        (minHeap.size() > maxHeap.size() ? (double)minHeap.peek() : (double)maxHeap.peek());
    }
}
