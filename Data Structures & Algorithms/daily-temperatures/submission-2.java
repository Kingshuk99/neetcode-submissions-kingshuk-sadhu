class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int ind = stack.pop();
                ans[ind] = i - ind;
            }
            stack.push(i);
        }
        return ans;
    }
}
