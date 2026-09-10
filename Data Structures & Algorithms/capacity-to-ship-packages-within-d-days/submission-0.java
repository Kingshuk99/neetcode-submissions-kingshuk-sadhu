class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxW = 0, minW = 0;

        for(int weight : weights) {
            maxW += weight;
        }

        int capacity = maxW;

        while(minW <= maxW) {
            int midW = minW + (maxW - minW) / 2;
            if(canLoad(weights, midW, days)) {
                capacity = midW;
                maxW = midW - 1;
            } else {
                minW = midW + 1;
            }
        }
        return capacity;
    }

    private boolean canLoad(int[] weights, int cap, int days) {
        int currW = 0, currDays = 1;
        for(int weight : weights) {
            if (weight > cap) {
                return false; 
            }
            if (currW + weight > cap) {
                currDays++; // Move to the next day
                currW = 0;  // Reset current day's weight
            
                // BUG 2 FIX: Early exit check is now accurate
                if (currDays > days) { 
                    return false;
                }
            }
            currW += weight;
        }
        return true;
    }
}