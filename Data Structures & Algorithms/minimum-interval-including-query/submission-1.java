class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0]==b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if(a[0]==b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        Map<Integer, Integer> res = new HashMap<>();
        int i = 0;

        for(int q : Arrays.stream(queries).sorted().toArray()) {
            while(i<intervals.length && q >= intervals[i][0]) {
                int l = intervals[i][0], r = intervals[i][1];
                minHeap.offer(new int[]{r-l+1, r});
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1]<q) {
                minHeap.poll();
            }
            res.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }

        int[] ans = new int[queries.length];
        for(i=0; i<queries.length; i++) {
            ans[i] = res.get(queries[i]);
        }
        return ans;
    }
}
