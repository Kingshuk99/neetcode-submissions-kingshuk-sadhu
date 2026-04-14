class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minK = 1, ans = 1, maxK = 1;
        for(int pile : piles) {
            maxK = Math.max(pile, maxK);
        }

        ans = maxK;

        while(minK<=maxK) {
            int k = minK + (maxK-minK)/2;
            int requiredTime = calculateTime(piles, k);
            if(requiredTime > h) {
                minK = k+1;
            }
            else {
                ans = k;
                maxK = k-1;
            }
        }
        return ans;
    }
    private int calculateTime(int[] piles, int k) {
        int time = 0;
        for(int pile : piles) {
            time += (Math.ceil((double)pile/k));
        }
        return time;
    }
}
