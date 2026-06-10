class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for(int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for(int num : counts.keySet()) {
            buckets[counts.get(num)].add(num);
        }

        int[] topK = new int[k];
        int ind = 0;

        for(int i = nums.length; i >= 0 && k > 0; i--) {
            if(buckets[i].size() == 0) {
                continue;
            }
            int j = 0;
            while(j < buckets[i].size() && k > 0) {
                topK[ind++] = buckets[i].get(j++);
                k--;
            }
        }

        return topK;
    }
}
