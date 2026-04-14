class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 0) {
            return 0;
        }

        int[][] cars = new int[position.length][2];

        for(int i=0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> (b[0] - a[0]));

        int fleetCount = 1;

        double time = (double) (target - cars[0][0]) / (double) cars[0][1];

        for(int i=1; i<cars.length; i++) {
            double currTime = (target - cars[i][0]) / (double) cars[i][1];
            
            if(currTime > time) {
                time = currTime;
                fleetCount++;
            }
        }

        return fleetCount;
    }
}
