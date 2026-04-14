class Solution {
    public int maxArea(int[] heights) {
        int water = 0;
        int left = 0, right = heights.length-1;

        while(left < right) {
            water = Math.max(water, (right - left)*Math.min(heights[left], heights[right]));
            if(heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return water;
    }
}
