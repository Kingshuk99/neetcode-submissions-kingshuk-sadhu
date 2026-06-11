class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> lens = new HashMap<>();
        int len = 0;
        for(int num : nums) {
            if(lens.containsKey(num)) {
                continue;
            }
            lens.put(num, lens.getOrDefault(num - 1, 0) + 
            lens.getOrDefault(num + 1, 0) + 1);

            lens.put(num - lens.getOrDefault(num - 1, 0), lens.get(num));
            lens.put(num + lens.getOrDefault(num + 1, 0), lens.get(num));

            len = Math.max(len, lens.get(num));
        }

        return len;
    }
}
