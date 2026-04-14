class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> currentheight = new Stack<>();
        int maxArea = heights[0];
        currentheight.push(new int[] {0, heights[0]});

        int i = 1;

        for(i=1; i<heights.length; i++) {
            int ind = i;
            while(!currentheight.isEmpty() && currentheight.peek()[1]>heights[i]) {
                int[] prev = currentheight.peek();
                ind = prev[0];
                currentheight.pop();
                maxArea = Math.max(maxArea, prev[1]*(i-ind));
            }
            currentheight.push(new int[] {ind, heights[i]});
        }

        while(!currentheight.isEmpty()) {
            int[] prev = currentheight.pop();
            maxArea = Math.max(maxArea, prev[1]*(i-prev[0]));
        }

        return maxArea;
    }
}
