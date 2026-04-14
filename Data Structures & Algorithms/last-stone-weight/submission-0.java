class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        for(int stone : stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size()>1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if(first > second) {
                maxHeap.offer(first-second);
            }
        }
        maxHeap.offer(0);
        return maxHeap.peek();
    }
}
