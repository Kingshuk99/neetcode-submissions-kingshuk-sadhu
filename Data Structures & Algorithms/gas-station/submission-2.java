class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totGas = 0, totCost = 0;
        for(int i=0; i<gas.length; i++) {
            totGas += gas[i];
            totCost += cost[i];
        }
        if(totGas < totCost) {
            return -1;
        }
        int extra = 0, ind = 0;

        for(int i=0; i<gas.length; i++) {
            extra += (gas[i]-cost[i]);
            if(extra < 0) {
                extra = 0;
                ind = i+1;
            }
        }

        return ind;
    }
}
