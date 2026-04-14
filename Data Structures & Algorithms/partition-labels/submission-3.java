class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> boundary = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            boundary.put(s.charAt(i), i);
        }

        int size = 0, end = 0;

        for(int i=0; i<s.length(); i++) {
            size++;
            end = Math.max(end, boundary.get(s.charAt(i)));
            if(i==end) {
                ans.add(size);
                size = 0;
            }
        }
        return ans;
    }
}
