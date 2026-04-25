class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if(maxHeap.size() - minHeap.size() > 1 || 
        (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())) {
            minHeap.offer(maxHeap.poll());
        }

        if(minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return minHeap.size() > maxHeap.size() ? minHeap.peek() :
        maxHeap.peek();
    }
}
