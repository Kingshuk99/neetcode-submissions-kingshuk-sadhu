class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> tempInd = new Stack<>();
        int[] ans = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++) {
            while(!tempInd.isEmpty() && temperatures[tempInd.peek()]<temperatures[i]) {
                int ind = tempInd.pop();
                ans[ind] = i-ind;
            }
            tempInd.push(i);
        }

        return ans;
    }
}
