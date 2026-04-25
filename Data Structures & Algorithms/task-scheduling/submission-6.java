class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for(char task : tasks) {
            counts[task - 'A']++;
        }

        Arrays.sort(counts);
        int maxF = counts[25];
        int maxFCount = 1, i = 24;

        while(counts[i] == maxF) {
            maxFCount++;
            i--;
        }

        return Math.max(tasks.length, 
        (maxF - 1) * (n + 1) + maxFCount);
    }
}
