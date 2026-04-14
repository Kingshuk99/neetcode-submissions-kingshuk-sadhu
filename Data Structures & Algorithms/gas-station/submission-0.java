class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        } 

        int tot = 0;
        int ind = 0;

        for(int i=0; i<gas.length; i++) {
            tot += (gas[i]-cost[i]);

            if(tot<0) {
                tot = 0;
                ind = i+1;
            }
        }

        return ind;
    }
}
