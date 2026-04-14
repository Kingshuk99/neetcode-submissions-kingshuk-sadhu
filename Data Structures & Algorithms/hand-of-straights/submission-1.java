class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> counts = new HashMap<>();

        for(int handValue :  hand) {
            if(!counts.containsKey(handValue)) {
                counts.put(handValue, 0);
            }
            counts.put(handValue, counts.get(handValue) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(counts.keySet());

        while(!minHeap.isEmpty()) {
            int minVal = minHeap.peek();

            for(int i=minVal; i<minVal+groupSize; i++) {
                if(!counts.containsKey(i)) {
                    return false;
                }
                counts.put(i, counts.get(i)-1);
                if(counts.get(i)==0) {
                    if(i != minHeap.peek()) {
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }

        return true;
    }
}
