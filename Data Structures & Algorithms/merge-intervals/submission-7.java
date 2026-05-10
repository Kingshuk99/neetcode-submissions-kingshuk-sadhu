class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        List<int[]> intervalList = new ArrayList<>();
        int[] currInterval = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if(currInterval[1] < interval[0]) {
                intervalList.add(currInterval);
                currInterval = interval;
                continue;
            }

            currInterval[0] = Math.min(currInterval[0], interval[0]);
            currInterval[1] = Math.max(currInterval[1], interval[1]);
        }

        intervalList.add(currInterval);
        int[][] ans = new int[intervalList.size()][2];

        for(int i = 0; i < intervalList.size(); i++) {
            ans[i] = intervalList.get(i);
        }

        return ans;
    }
}
