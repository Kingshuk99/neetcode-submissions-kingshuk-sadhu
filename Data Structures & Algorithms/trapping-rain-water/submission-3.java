class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length-1, water = 0,
         leftMax = height[0], rightMax = height[r];

        while(l<r) {
            if(leftMax<=rightMax) {
                l++;
                leftMax = Math.max(height[l], leftMax);
                water += (leftMax-height[l]);
            }
            else {
                r--;
                rightMax = Math.max(height[r], rightMax);
                water += (rightMax-height[r]);
            }
        }
        return water;
    }
}
