class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 0) {
            return 0;
        }

        int[][] cars = new int[position.length][2];

        for(int i = 0; i < position.length; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(cars, (a, b) -> (b[0] - a[0]));

        double time = (double) (target - cars[0][0]) / (double) cars[0][1];
        int fleetCount = 1;

        for(int i = 1; i < position.length; i++) {
            double currTime = (double) (target - cars[i][0]) / (double) cars[i][1];

            if(currTime > time) {
                time = currTime;
                fleetCount++;
            }
        }

        return fleetCount;
    }
}
