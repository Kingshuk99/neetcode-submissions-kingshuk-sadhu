class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for(int[] interval : intervals) {
            if(newInterval==null || interval[1] < newInterval[0]) {
                ans.add(interval);
            }
            else if(newInterval[1] < interval[0]) {
                ans.add(newInterval);
                ans.add(interval);
                newInterval = null;
            }
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if(newInterval != null) {
            ans.add(newInterval);
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
