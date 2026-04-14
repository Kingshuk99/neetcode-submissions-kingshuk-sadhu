class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            if(a[0]==b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for(int i=0; i<intervals.length; i++) {
            if(intervals[i][0]<=end) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            } else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            if(i==intervals.length-1) {
                res.add(new int[]{start, end});
            }
        }

        int[][] ans = new int[res.size()][2];
        for(int i=0; i<res.size(); i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;
    }
}
