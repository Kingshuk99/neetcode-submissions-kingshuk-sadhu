class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0]==b[0]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        List<int[]> res = new ArrayList<>();
        int[] currInterval = null;
        for(int[] interval : intervals) {
            if(currInterval==null) {
                currInterval = interval;
                continue;
            }
            if(interval[0] <= currInterval[1]) {
                currInterval[0] = Math.min(interval[0], currInterval[0]);
                currInterval[1] = Math.max(interval[1], currInterval[1]);
            } else {
                res.add(currInterval);
                currInterval = interval;
            }
        }

        res.add(currInterval);

        int[][] ans = new int[res.size()][2];
        for(int i=0; i<res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
