class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int l = 0, r = points.length - 1;
        int pivot = points.length;

        while(pivot != k) {
            pivot = partition(points, l, r);
            if(pivot < k) {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }

        int[][] ans = new int[k][2];

        for(int i = 0; i < k; i++) {
            ans[i] = points[i];
        }

        return ans;
    }

    private int partition(int[][] points, int l, int r) {
        int pivot = r, pivotDist = euclidean(points[r]);
        int i = l;
        for(int j = l; j < r; j++) {
            if(euclidean(points[j]) <= pivotDist) {
                int[] temp = points[j];
                points[j] = points[i];
                points[i] = temp;
                i++;
            }
        }

        int[] temp = points[pivot];
        points[pivot] = points[i];
        points[i] = temp;
        return i;
    }

    private int euclidean(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
