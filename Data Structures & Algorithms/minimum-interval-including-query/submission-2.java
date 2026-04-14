class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0]==b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        Map<Integer, Integer> res = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->{
            if(a[0]==b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        int i=0;

        for(int query : Arrays.stream(queries).sorted().toArray()) {
            while(i<intervals.length && intervals[i][0]<=query) {
                minHeap.offer(new int[] {intervals[i][1]-intervals[i][0]+1, 
                intervals[i][0]});
                i++;
            }
            while(!minHeap.isEmpty() && 
            minHeap.peek()[1]+minHeap.peek()[0]-1<query) {
                minHeap.poll();
            }
            res.put(query, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }

        int[] ans = new int[queries.length];
        for(i=0; i<queries.length; i++) {
            ans[i] = res.get(queries[i]);
        }

        return ans;
    }
}
