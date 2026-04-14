class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        for(char task : tasks) {
            if(!counts.containsKey(task)) {
                counts.put(task, 0);
            }
            counts.put(task, counts.get(task) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder());
        maxHeap.addAll(counts.values());

        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            if(!q.isEmpty() && time >= q.peek()[1]) {
                maxHeap.offer(q.poll()[0]);
            }

            if(!maxHeap.isEmpty()) {
                int count = maxHeap.poll() - 1;
                if(count > 0) {
                    q.offer(new int[]{count, time + n + 1});
                }
            }

            time ++;
        }

        return time;
    }
}
