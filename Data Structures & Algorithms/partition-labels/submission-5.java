class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> endInd = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            endInd.put(ch, i);
        }

        List<Integer> ans = new ArrayList<>();
        int len = 0, goal = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            goal = Math.max(goal, endInd.get(ch));
            len++;
            if(goal==i) {
                ans.add(len);
                len = 0;
            }
        }

        return ans;
    }
}
