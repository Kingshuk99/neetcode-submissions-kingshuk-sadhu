class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = 
        new PriorityQueue<>(Collections.reverseOrder());

        for(int count : map.values()) {
            maxHeap.offer(count);
        }

        Queue<int[]> queue = new LinkedList<>();
        int cycles = 0;

        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            while(!queue.isEmpty() && queue.peek()[0] <= cycles) {
                maxHeap.offer(queue.poll()[1]);
            }

            if(!maxHeap.isEmpty()) {
                int next = maxHeap.poll();
                next--;
                if(next > 0) {
                    queue.offer(new int[] {cycles + n + 1, next});
                }
            }
            cycles++;
        }
        return cycles;
    }
}
