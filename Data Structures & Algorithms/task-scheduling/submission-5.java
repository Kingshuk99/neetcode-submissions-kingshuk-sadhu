class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for(char task : tasks) {
            counts[task - 'A']++;
        }

        Arrays.sort(counts);
        int maxF = counts[25];
        int idle = n * (maxF - 1);

        for(int i = 24; i >=0; i--) {
            idle -= Math.min(maxF - 1, counts[i]);
        }

        return idle > 0 ? tasks.length + idle : tasks.length;
    }
}
