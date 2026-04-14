class Solution {
    private int requiredHours(int[] piles, int k) {
        int hours = 0;
        for(int pile : piles) {
            hours += Math.ceil((double) pile / k);
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxK = Arrays.stream(piles).max().getAsInt();

        int minK = 1;
        int ans = maxK;

        while(minK<=maxK) {
            int k = minK + (maxK-minK)/2;
            int requiredH = requiredHours(piles, k);
            System.out.println(requiredH);
            if(requiredH>h) {
                minK = k+1;
            }
            else {
                ans = k;
                maxK = k-1;
            }
        }
        return ans;
    }
}
