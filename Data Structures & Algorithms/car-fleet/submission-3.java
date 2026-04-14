class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for(int i=0; i<n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        double[] time = new double[n];

        Arrays.sort(cars, (p1, p2) -> Double.compare(p2[0], p1[0]));

        int carfleets = 0;

        for(int i=0; i<n; i++) {
            time[i] = (target-cars[i][0])/cars[i][1];
            if(i>=1 && time[i]<=time[i-1]) {
                time[i] = time[i-1];
            }
            else {
                carfleets++;
            }
        }

        return carfleets;
    }
}
