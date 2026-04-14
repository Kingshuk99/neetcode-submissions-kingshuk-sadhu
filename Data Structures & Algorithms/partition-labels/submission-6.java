class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> endings = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            endings.put(s.charAt(i), i);
        }
        int len = 0, goal = 0;
        for(int i=0; i<s.length(); i++) {
            goal = Math.max(goal, endings.get(s.charAt(i)));
            len++;
            if(goal==i) {
                ans.add(len);
                len = 0;
            }
        }
        return ans;
    }
}
