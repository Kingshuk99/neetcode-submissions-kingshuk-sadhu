class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>();

        for(int[] interval : intervals) {
            if(newInterval == null) {
                intervalList.add(interval);
                continue;
            }

            if(newInterval[1] < interval[0]) {
                intervalList.add(newInterval);
                intervalList.add(interval);
                newInterval = null;
                continue;
            }

            if(interval[1] < newInterval[0]) {
                intervalList.add(interval);
                continue;
            }

            newInterval[0] = Math.min(interval[0], newInterval[0]);
            newInterval[1] = Math.max(interval[1], newInterval[1]);
        }

        if(newInterval != null){
            intervalList.add(newInterval);
        }

        int[][] ans = new int[intervalList.size()][2];
        int i = 0;

        for(int[] interval : intervalList) {
            ans[i++] = interval;
        }

        return ans;
    }
}
