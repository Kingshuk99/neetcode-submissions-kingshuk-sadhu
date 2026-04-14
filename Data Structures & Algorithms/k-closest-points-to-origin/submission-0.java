class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                int dist1 = p1[0]*p1[0]+p1[1]*p1[1];
                int dist2 = p2[0]*p2[0]+p2[1]*p2[1];
                return Integer.compare(dist1, dist2);
            }
        });

        for(int[] point : points) {
            minHeap.offer(point);
        }

        int[][] ans = new int[k][2];
        int i = 0;
        while(k>i) {
            ans[i] = minHeap.poll();
            i++;
        }

        return ans;
    }
}
