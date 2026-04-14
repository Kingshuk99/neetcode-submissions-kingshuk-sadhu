class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        int i = 0;
        for(; i<heights.length; i++) {
            int ind = i;
            while(!stack.isEmpty() && stack.peek()[0] > heights[i]) {
                int[] curr = stack.pop();
                ind = curr[1];
                maxArea = Math.max(maxArea, (i - ind) * curr[0]);
            }
            stack.push(new int[] {heights[i], ind});
        }

        while(!stack.isEmpty()) {
            int[] curr = stack.pop();
            maxArea = Math.max(maxArea, (i - curr[1]) * curr[0]);
        }

        return maxArea;
    }
}
