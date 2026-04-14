class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length > h) {
            return -1;
        }
        int minK = 1, maxK = 1, k = -1;

        for(int pile : piles) {
            maxK = Math.max(maxK, pile);
        }

        while (minK <= maxK) {
            int midK = minK + (maxK - minK)/2;

            if(canEat(piles, midK, h)) {
                k = midK;
                maxK = midK-1;
            } else {
                minK = midK+1;
            }
        }

        return k;
    }

    private boolean canEat(int[] piles, int k, int h) {
        int time = 0;
        for(int pile : piles) {
            time += ((pile / k) + (pile % k != 0 ? 1 : 0));
            if(time > h) {
                return false;
            }
        }
        return true;
    }
}
