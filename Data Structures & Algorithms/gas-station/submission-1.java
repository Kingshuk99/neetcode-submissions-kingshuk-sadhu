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

        int excessGas = 0, ind = 0;

        for(int i=0; i<gas.length; i++) {
            excessGas += (gas[i]-cost[i]);

            if(excessGas<0) {
                excessGas = 0;
                ind = i+1;
            }
        }

        return ind;
    }
}
