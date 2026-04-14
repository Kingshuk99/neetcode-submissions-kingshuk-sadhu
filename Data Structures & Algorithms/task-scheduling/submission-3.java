class Solution {
    public int leastInterval(char[] tasks, int n) {
        int cycles = 0;
        Map<Character, Integer> counts = new HashMap<>();
        for(char task : tasks) {
            counts.put(task, counts.getOrDefault(task, 0)+1);
        }
        PriorityQueue<Integer> maxHeap = 
        new PriorityQueue<>(Collections.reverseOrder());
        for(int count : counts.values()) {
            maxHeap.offer(count);
        }
        Queue<int[]> queue = new LinkedList<>();
        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            if(!queue.isEmpty() && cycles >= queue.peek()[0]) {
                maxHeap.offer(queue.poll()[1]);
            }
            if(!maxHeap.isEmpty()) {
                int curr = maxHeap.poll();
                if(curr > 1) {
                    queue.offer(new int[]{cycles+n+1, curr-1});
                }
            }
            cycles++;
        }

        return cycles;
    }
}
