class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0, i = 0;
        Stack<int[]> s = new Stack<>();

        for(i=0; i<heights.length; i++) {
            int ind = i;
            while(!s.isEmpty() && s.peek()[1]>heights[i]) {
                int[] curr = s.pop();
                int area = (i-curr[0])*curr[1];
                ind = curr[0];
                maxArea = Math.max(area, maxArea);
            }
            s.push(new int[]{ind, heights[i]});
        }

        while(!s.isEmpty()) {
            int[] curr = s.pop();
            maxArea = Math.max(maxArea, (i-curr[0])*curr[1]);
        }

        return maxArea;
    }
}
