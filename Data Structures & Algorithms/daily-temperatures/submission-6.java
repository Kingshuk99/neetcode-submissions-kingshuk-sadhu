class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] highers = new int[n];

        for(int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while(j < n && temperatures[j] <= temperatures[i]) {
                if(highers[j] == 0) {
                    j = n;
                    break;
                }
                j += highers[j];
            }
            if(j < n) {
                highers[i] = j - i;
            }
        }

        return highers;
    }
}
