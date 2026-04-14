class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
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
        if(minHeap.size()==maxHeap.size()) {
            return ((double) (maxHeap.peek() + minHeap.peek())) / 2;
        }
        return maxHeap.size() > minHeap.size() ? (double) maxHeap.peek() : 
        (double) minHeap.peek();
    }
}
