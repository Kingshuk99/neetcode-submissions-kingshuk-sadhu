class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> ranges = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(!ranges.containsKey(ch)) {
                ranges.put(ch, new int[]{i, i});
                continue;
            }
            ranges.get(ch)[1] = i;
        }

        List<Integer> ans = new ArrayList<>();

        List<int[]> rangeList = new ArrayList<>();
        for(int[] range : ranges.values()) {
            rangeList.add(range);
        }
        Collections.sort(rangeList, (a, b)->Integer.compare(a[0], b[0]));
        int start = 0, end = rangeList.get(0)[1];

        for(int[] range : rangeList) {
            System.out.println(range[0]+" "+range[1]);
        }
        
        for(int i=1; i<rangeList.size(); i++) {
            int[] range = rangeList.get(i);
            if(end>=range[0]) {
                end = Math.max(end, range[1]);
                continue;
            }
            ans.add(end-start+1);
            start = range[0];
            end = range[1];
        }
        ans.add(end-start+1);
        return ans;
    }
}
