class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> endIndex = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            endIndex.put(ch, i);
        }

        List<Integer> ans = new ArrayList<>();
        int len = 0, goal = 0;

        for(int i=0; i<s.length(); i++) {
            goal = Math.max(goal, endIndex.get(s.charAt(i)));
            len++;

            if(goal==i) {
                ans.add(len);
                len = 0;
            }
        }

        return ans;
    }
}
