class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> endIndex = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            endIndex.put(s.charAt(i), i);
        }

        int end = 0, len = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            end = Math.max(end, endIndex.get(s.charAt(i)));
            len++;
            if(end == i) {
                ans.add(len);
                len = 0;
            }
        }
        return ans;
    }
}
