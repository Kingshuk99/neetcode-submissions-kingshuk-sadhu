class MedianFinder {
    private PriorityQueue<Integer> minHeap, maxHeap;
    int n1, n2;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        n1 = 0;
        n2 = 0;
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        n2++;
        if(n2-n1>1 || (!minHeap.isEmpty() && 
        maxHeap.peek()>minHeap.peek())) {
            minHeap.offer(maxHeap.poll());
            n1++;
            n2--;
        }
        if(n1-n2>1) {
            maxHeap.offer(minHeap.poll());
            n2++;
            n1--;
        }
    }
    
    public double findMedian() {
        return n1 == n2 ? (double)(minHeap.peek() + maxHeap.peek())/2 : 
        (n1 > n2 ? (double)minHeap.peek() : (double)maxHeap.peek());
    }
}
