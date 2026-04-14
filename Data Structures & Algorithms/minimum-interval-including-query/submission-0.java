class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
            );

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Map<Integer, Integer> res = new HashMap<>();

        int i = 0;

        for(int q : Arrays.stream(queries).sorted().toArray()) {
            while(i < intervals.length && intervals[i][0] <= q) {
                minHeap.offer(new int[] {intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            res.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }

        int[] ans = new int[queries.length];

        for(int j = 0; j < queries.length; j++) {
            ans[j] = res.get(queries[j]);
        }

        return ans;
    }
}
