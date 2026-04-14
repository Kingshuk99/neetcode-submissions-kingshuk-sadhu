class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        List[] buckets = new ArrayList[nums.length+1];

        for(int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for(int i=0; i<=nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(int key : counts.keySet()) {
            buckets[counts.get(key)].add(key);
        }

        int[] topk = new int[k];

        for(int i=nums.length; i>=0 && k>0; i--) {
            int ind = 0;
            while(ind < buckets[i].size() && k > 0) {
                k--;
                topk[k] = (int) buckets[i].get(ind++);
            }
        }

        return topk;
    }
}
