class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int left = 0, right = heights.length - 1;

        while(left < right) {
            maxWater = Math.max(maxWater, (right - left) * 
            Math.min(heights[left], heights[right]));

            if(heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
