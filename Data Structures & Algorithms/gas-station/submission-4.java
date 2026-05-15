class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int fuel = 0, ind = 0;
        for(int i = 0; i < gas.length; i++) {
            fuel += (gas[i] - cost[i]);
        }

        if(fuel < 0) {
            return -1;
        }

        fuel = 0;

        for(int i = 0; i < gas.length; i++) {
            fuel += (gas[i] - cost[i]);
            if(fuel < 0) {
                fuel = 0;
                ind = i + 1;
            }
        }
        return ind;
    }
}
