class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        for(char task : tasks) {
            counts.put(task, counts.getOrDefault(task, 0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder());
        maxHeap.addAll(counts.values());
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            if(!q.isEmpty() && q.peek()[0]<=time) {
                maxHeap.offer(q.poll()[1]);
            }
            if(!maxHeap.isEmpty()) {
                int curr = maxHeap.poll();
                if(curr > 1) {
                    q.offer(new int[]{time+n+1, curr-1});
                }
            }
            time++;
        }
        return time;
    }
}
