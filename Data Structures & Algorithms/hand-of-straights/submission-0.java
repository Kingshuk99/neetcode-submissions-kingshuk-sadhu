class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) {
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int n:hand) {
            count.put(n, 1+count.getOrDefault(n, 0));
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(count.keySet());

        while(!minHeap.isEmpty()) {
            int first = minHeap.peek();

            for(int i=first; i<first+groupSize; i++) {
                if(!count.containsKey(i)) {
                    return false;
                }

                count.put(i, count.get(i)-1);
                if(count.get(i)==0) {
                    if(i!=minHeap.peek()) {
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }

        return true;
    }
}
