class Solution {
    public int maxArea(int[] heights) {
        int ans = 0, l = 0, r = heights.length-1;

        while(l<r) {
            ans = Math.max(ans, (r-l)*Math.min(heights[l], heights[r]));
            if(heights[l]<heights[r]) {
                l++;
            }
            else {
                r--;
            }
        }

        return ans;
    }
}
