class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder());
        
        for(int stone : stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            int rem = first - second;
            if(rem > 0) {
                maxHeap.offer(rem);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
