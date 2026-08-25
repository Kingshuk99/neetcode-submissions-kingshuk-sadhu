class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        int maxPossibleValues = (3 - 1);

        for(int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);

            if(counts.size() > maxPossibleValues) {
                Map<Integer, Integer> newCounts = new HashMap<>();
                for(int key : counts.keySet()) {
                    if(counts.get(key) > 1) {
                        newCounts.put(key, counts.get(key) - 1);
                    }
                }
                counts = newCounts;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int key : counts.keySet()) {
            int freq = 0;
            for(int num : nums) {
                if(key == num) {
                    freq++;
                }
                if(freq > nums.length / 3) {
                    res.add(key);
                    break;
                }
            }
        }
        return res;
    }
}