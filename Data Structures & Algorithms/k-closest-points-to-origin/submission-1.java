class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            new Comparator<int[]>() {
                public int compare(int[] point1, int[] point2) {
                    int dist1 = point1[0] * point1[0] + point1[1] * point1[1];
                    int dist2 = point2[0] * point2[0] + point2[1] * point2[1];
                    return Integer.compare(dist2, dist1);
                }
            });

        for(int[] point : points) {
            maxHeap.offer(point);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[k][2];
        int i = 0;
        while(!maxHeap.isEmpty()) {
            ans[i++] = maxHeap.poll();
        }

        return ans;
    }
}
