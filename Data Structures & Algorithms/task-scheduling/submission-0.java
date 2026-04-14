class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();

        for(char task : tasks) {
            counts.put(task, counts.getOrDefault(task, 0)+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(counts.values());

        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while(!maxHeap.isEmpty() || !q.isEmpty()) {
            if(!q.isEmpty() && time>=q.peek()[1]) {
                int[] newTask = q.poll();
                maxHeap.offer(newTask[0]);
            }

            time++;

            if(!maxHeap.isEmpty()) {
                int count = maxHeap.poll()-1;

                if(count>0) {
                    q.offer(new int[]{count, time+n});
                }
            }
        }

        return time;
    }
}
