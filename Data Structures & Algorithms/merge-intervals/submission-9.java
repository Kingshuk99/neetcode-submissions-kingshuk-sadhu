class Solution {
    public int[][] merge(int[][] intervals) {
        int maxStart = 0;
        for(int[] interval : intervals) {
            maxStart = Math.max(maxStart, interval[0]);
        }

        int[] dp = new int[maxStart + 1];
        for(int i = 0; i <= maxStart; i++) {
            dp[i] = -1;
        }

        for(int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            dp[start] = Math.max(end, dp[start]);
        }

        int start = -1, finish = -1;
        List<int[]> ans = new ArrayList<>();

        for(int i = 0; i < dp.length; i++) {
            if(dp[i] != -1) {
                if(start == -1) {
                    start = i;
                }
                finish = Math.max(dp[i], finish);
            }

            if(finish == i) {
                ans.add(new int[]{start, finish});
                finish = -1;
                start = -1;
            }
        }

        if(start != -1) {
            ans.add(new int[]{start, finish});
        }

        if(intervals.length == ans.size()) {
            return intervals;
        }

        int[][] res = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}
