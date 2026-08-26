class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, lMax = 0, rMax = 0;
        int water = 0;

        while(l <= r) {
            if(lMax <= rMax) {
                lMax = Math.max(lMax, height[l]);
                water += (lMax - height[l++]);
            } else {
                rMax = Math.max(rMax, height[r]);
                water += (rMax - height[r--]);
            }
        }

        return water;
    }
}
