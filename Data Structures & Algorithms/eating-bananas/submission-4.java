class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1, ans = 1;
        for(int pile : piles) {
            high = Math.max(high, pile);
        }

        while(low<=high) {
            int mid = low + (high-low)/2;
            if(canEat(piles, mid, h)) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    private boolean canEat(int[] piles, int rate, int h) {
        int time = 0;
        for(int pile : piles) {
            time += pile/rate;
            pile = pile%rate;
            if(pile!=0) {
                time++;
            }
        }
        return time<=h;
    }
}
