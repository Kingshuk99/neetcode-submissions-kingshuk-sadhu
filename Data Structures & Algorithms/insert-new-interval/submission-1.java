class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for(int[] interval : intervals) {
            if(newInterval==null || interval[1]<newInterval[0]) {
                ans.add(interval);
            } else if(newInterval[1]<interval[0]) {
                ans.add(newInterval);
                ans.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if(newInterval!=null) {
            ans.add(newInterval);
        }
        int[][] res = new int[ans.size()][2];
        for(int i=0; i<ans.size(); i++) {
            res[i][0] = ans.get(i)[0];
            res[i][1] = ans.get(i)[1];
        }

        return res;
    }
}
